package com.marketing.tool.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.repository.IndustryReportFormRepository;

@Service
@Validated
public class IndustryReportFormServiceImpl  extends ReportFormServiceImpl  implements IndustryReportFormService {

	@Inject
	public IndustryReportFormServiceImpl(IndustryReportFormRepository repository) {
		super(repository);
	}
	

}
