package com.marketing.tool.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.repository.CPDPRportFormRepository;

@Service
@Validated
public class CPDPReportFormServiceImpl  extends ReportFormServiceImpl  implements CPDPReportFormService {

	@Inject
	public CPDPReportFormServiceImpl(CPDPRportFormRepository repository) {
		super(repository);
	}
	

}
