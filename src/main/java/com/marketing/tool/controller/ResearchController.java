package com.marketing.tool.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.repository.AuthorRepository;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.MasterIndustriesService;
import com.marketing.tool.service.PublishedReportsService;
import com.marketing.tool.service.ReportService;
import com.marketing.tool.service.ResearchReportsService;
import com.marketing.tool.vo.SearchCriteria;

/**
 * @author Anilkumar Ravula
 *
 */
@Controller
public class ResearchController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ResearchController.class);
	   
	 
	 	@Autowired
		private LoginUserService loginUserService;
	 	
	 	@Autowired
	    private ReportService reportFormService;
	 	@Autowired
	 	private ResearchReportsService researchReportsService;
	 	@Autowired
	 	private PublishedReportsService publishedReportsService;
	 	
	 	@Autowired
	 	private MasterIndustriesService masterIndustriesService;
	 	
	 	@Autowired
	 	private AuthorRepository authorRepository;
	 	
	 	
	 	
	 	
	 	@RequestMapping(value = "/freefolk/getPublishedReports/{pageNumber}/{noOfPages}", method = RequestMethod.POST)
	    public @ResponseBody EditReports loginSuccessPage(@RequestBody SearchCriteria criteria,@PathVariable Integer pageNumber,@PathVariable Integer noOfPages,@RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout, Model model1) {
	        
	        //User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
	      
	        return researchReportsService.getPublishedReportsFromSearchCriteria(criteria,pageNumber,noOfPages);
	    }
	 	
	 	
	 	@RequestMapping(value = "/freefolk/getPublishedReports", method = RequestMethod.GET)
	    public ModelAndView publishedReports( Model model1) {
	         
	        ModelAndView model = new ModelAndView();
	        ArrayList<Integer> ids = new ArrayList<>();
	        ids.add(1);
	        
	        Map<Integer,List<Integer>> maps = new HashMap<>();
	        
	       // List<Integer>  counts= new LinkedList<Integer>();
	        List<Object[]> idsL = authorRepository.findAuthorReportsByMonthWise(65536, ids);
	       // for(int i=0;i<13;i++) {
	       // 	counts.add(0);
	       // }
	        for (Object[] objects : idsL) {
	        	List<Integer>  counts = null;
	        	if(maps.containsKey((int)objects[2])) {
	        	  counts =  maps.get((int)objects[2]);
	        	} else {
	        		counts = getEmptyLinkedList();
	        		maps.put((int)objects[2], counts);
	        	}
	        	int monthNum = ((int)objects[1])-1;
	        	int cnt = counts.get(monthNum);
	        	cnt = cnt+ Long.valueOf((long)objects[0]).intValue();
	        	counts.set(monthNum, cnt);
			}
	        System.out.println(maps);
	        model.addObject("totalCount",publishedReportsService.getTotalPublishedRecordsCount());
	        model.addObject("industries",masterIndustriesService.findAllIndustries());
	        model.setViewName("researchStore");
	        return model;
	    }
	    
	    public static List<Integer> getEmptyLinkedList() {
	        List<Integer>  counts= new LinkedList<Integer>();
	        for(int i=0;i<13;i++) {
	        	counts.add(0);
	        }
	        
	        return counts; 
	    }
 }
