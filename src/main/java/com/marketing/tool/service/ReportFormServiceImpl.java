package com.marketing.tool.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AutoPopulatingList;

import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.ReportStatus;
import com.marketing.tool.domain.ReportWorkFlowStatus;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.repository.ReportFormRepository;
import com.marketing.tool.utility.Helper;


public class ReportFormServiceImpl implements ReportFormService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportFormServiceImpl.class);
	private final ReportFormRepository<ReportForm> repository;

	@Autowired
	private Helper helper;
	
	@Inject
	public ReportFormServiceImpl(final ReportFormRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public ReportForm save(@NotNull @Valid ReportForm reportForm) {
		AutoPopulatingList<ReportStatus> reportStatusSet = new AutoPopulatingList<ReportStatus>(ReportStatus.class);
		ReportStatus status = new ReportStatus();
		status.setReport(reportForm);
		status.setStatus(ReportWorkFlowStatus.CREATED.toString());
		status.setUser(helper.getPrincipalUser());
		status.setComments("reported created");
		status.setUserType(UserProfileType.AUTHOR.toString());
		reportStatusSet.add(status);
		reportForm.setReportStatuses(reportStatusSet);
		return repository.save(reportForm);
	}

	@Override
    @Transactional(readOnly = true)
	public List<ReportForm> getAllReports() {
		return repository.findAll();
	}

	@Override
	public ReportForm findByReportId(Integer reportFormId) {
		return repository.findByReportId(reportFormId);
	}

}
