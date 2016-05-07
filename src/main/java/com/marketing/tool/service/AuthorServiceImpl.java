package com.marketing.tool.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.AuthorReportsResp;
import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.reponse.builder.ReportsSearchResponseBuilder;
import com.marketing.tool.repository.AuthorRepository;
import com.marketing.tool.repository.ReportRepository;
import com.marketing.tool.repository.RoleRepository;
import com.marketing.tool.utility.ReportStatusEnum;
import com.marketing.tool.vo.ReportVo;

@Service
@Validated
public class AuthorServiceImpl extends UserServiceImpl implements AuthorService {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired	
	private ReportRepository reportRepository;
	
	
	
	
	@Inject
	public AuthorServiceImpl(AuthorRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	
	@Transactional
	public User save(@NotNull @Valid final User user) { 
		user.setAccountType(UserProfileType.AUTHOR.getUserProfileType());
		return super.save(user);
	}
	
	@Override
	public List<Author> findAuhtors(String country, List<Keyskills> skills)    {
		if(country==null || "any".equals(country) || "undefined".equals(country)) {
			return authorRepository.findByKeyskillsIn(skills);
		}
		return authorRepository.findByCountryAndKeyskillsIn(country, skills);
	}


	@Override
	public AuthorReportsResp getAuthorReports(int userId, int pageNumber, int results) {
		AuthorReportsResp  resp = new AuthorReportsResp();
		
		getAuthorPublishedReports(userId, pageNumber, results,resp);
		
		//caluclate monthly basis based on date
				
		//other reports
		 getAuthorReportsList(userId, pageNumber, results,resp);
		
		
		return resp;
	}
	
	public void getAuthorPublishedReports(int userId, int pageNumber, int results, AuthorReportsResp resp) {
		//build page request
		final PageRequest page = new PageRequest(pageNumber, results);

		//pulished reports
		List<Integer> published = new ArrayList<>();
		published.add(ReportStatusEnum.PUBLISHED.getValue());
		
		Page<ReportForm> publishedReports =reportRepository.findAuthorReports(userId, published, page);
		if(publishedReports != null  && pageNumber == 0) {
			resp.setPubRepCount(publishedReports.getTotalPages());
		}
		
		List<ReportVo> pubReVo =ReportsSearchResponseBuilder.buildReports(publishedReports.getContent());
		
		resp.setPulishedReports(pubReVo);
		
		//return pubReVo;
	}
	public void getAuthorReportsList(int userId, int pageNumber, int results, AuthorReportsResp resp) {
		//build page request
		final PageRequest page = new PageRequest(pageNumber, results);

		//pulished reports
		List<Integer> others = new ArrayList<>();
		others.add(ReportStatusEnum.PUBLISHER_PENDING.getValue());
		others.add(ReportStatusEnum.CREATED.getValue());
		others.add(ReportStatusEnum.REVIWER_COMMENTS.getValue());
		others.add(ReportStatusEnum.REVIWER_PENDING.getValue());
		
		Page<ReportForm> publishedReports =reportRepository.findAuthorReports(userId, others, page);
		if(publishedReports != null && pageNumber == 0) {
			resp.setOtherrepCount(publishedReports.getTotalPages());
		}
		List<ReportVo> pubReVo =ReportsSearchResponseBuilder.buildReports(publishedReports.getContent());
		resp.setRepList(pubReVo);
	}
	
	//Build Graphs
	
}
