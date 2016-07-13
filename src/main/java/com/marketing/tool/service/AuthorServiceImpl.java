package com.marketing.tool.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.AuthorReportsResp;
import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.ReportCommentsAlert;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.reponse.builder.ReportsSearchResponseBuilder;
import com.marketing.tool.repository.AuthorRepository;
import com.marketing.tool.repository.ReportCommentsAlertRepository;
import com.marketing.tool.repository.ReportRepository;
import com.marketing.tool.repository.ReportStatusRepository;
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
	
	@Autowired
	private ReportStatusRepository   reportStatusRepository;
	
	@Autowired	
	private ReportCommentsAlertRepository reportCommentsAlertRepository;
	
	
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
		
		List<ReportVo> pubReVo =ReportsSearchResponseBuilder.buildReports(publishedReports.getContent(),null,false);
		
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
		
		//comments alert -pre data
		Map<Integer,ReportCommentsAlert>  repMpa = null;
		//get Records for lastSeenDate
		List<ReportCommentsAlert> alertRecords  = reportCommentsAlertRepository.findByUserId(userId);
		if(!CollectionUtils.isEmpty(alertRecords)) {
			repMpa = new HashMap<>();
			for (ReportCommentsAlert reportCommentsAlert : alertRecords) {
				repMpa.put(reportCommentsAlert.getReportId(),reportCommentsAlert);
			}
		}
		
		Page<ReportForm> publishedReports =reportRepository.findAuthorReports(userId, others, page);
		if(publishedReports != null && pageNumber == 0) {
			resp.setOtherrepCount(publishedReports.getTotalPages());
		}
		
		List<ReportVo> pubReVo =ReportsSearchResponseBuilder.buildReports(publishedReports.getContent(), repMpa,true);
		
		////comments alert -post data
		
		resp.setRepList(pubReVo);
	}


	@Override
	public Author findById(Integer id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id);
	}
	
	

	@Override
	public AuthorReportsResp getPublishedRecordsCount(Integer year, Integer userId) {
		// TODO Auto-generated method stubMap<Integer,List<Integer>> maps = new HashMap<>();
	/*	ArrayList<Integer> ids = new ArrayList<>();
		ids.add(ReportStatusEnum.PUBLISHED.getValue());*/
        
       // List<Integer>  counts= new LinkedList<Integer>();
       // List<Object[]> idsL = authorRepository.findAuthorReportsByMonthWise(userId, ids);
		List<Object[]> idsL = authorRepository.findAuthorReportsByMonthWise(userId, year);
       // for(int i=0;i<13;i++) {
       // 	counts.add(0);
       // }
		//year and its count
		
        Map<Integer,List<Integer>> maps = new HashMap<>();
        for (Object[] objects : idsL) {
        	List<Integer>  counts = null;
        	if(maps.containsKey((int)objects[3])) {
        	  counts =  maps.get((int)objects[3]);
        	} else {
        		counts = getEmptyLinkedList();
        		maps.put((int)objects[3], counts);
        	}
        	int monthNum = ((int)objects[1])-1;
        	int cnt = counts.get(monthNum);
        	cnt = cnt+ Long.valueOf((long)objects[0]).intValue();
        	counts.set(monthNum, cnt);
		}
       // System.out.println(maps);
        AuthorReportsResp res = new AuthorReportsResp();
        res.setPublishedChartsData(maps);
		return res;
	}
	
  public static List<Integer> getEmptyLinkedList() {
    List<Integer>  counts= new LinkedList<Integer>();
    for(int i=0;i<12;i++) {
    	counts.add(0);
    }
    return counts; 
 }
	//Build Graphs
  @Override
	public Map<String, Integer> getReportsCount(String email) {
		
		Map<String, Integer>  resp = new HashMap<>();
		List<Object[]> summary = reportStatusRepository.reportsSummary(email);
		
		if(CollectionUtils.isEmpty(summary)) {
			return resp;
		}
		resp = new HashMap<>();
		for (Object[] objects : summary) {
			
			resp.put(ReportStatusEnum.fromValue((int)objects[0]), ((Long)objects[1]).intValue());
		}
		
		return resp;
	}

}
