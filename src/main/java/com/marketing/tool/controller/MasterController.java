package com.marketing.tool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.MasterEntity;
import com.marketing.tool.domain.master.AnalystPreference;
import com.marketing.tool.domain.master.CompanyTitle;
import com.marketing.tool.domain.master.CompanyType;
import com.marketing.tool.domain.master.Country;
import com.marketing.tool.domain.master.Currency;
import com.marketing.tool.domain.master.Industry;
import com.marketing.tool.domain.master.Keyskills;
import com.marketing.tool.domain.master.Occupation;
import com.marketing.tool.domain.master.ResearchType;
import com.marketing.tool.domain.master.TurnAroundTime;
import com.marketing.tool.domain.master.Units;
import com.marketing.tool.domain.master.UpdateCycle;
import com.marketing.tool.service.MasterService;

@Controller
@RequestMapping("/secure/master/")
public class MasterController<T> {
	
    //String[] createForms = {"keySkillsMaster","countryMaster"}; 
    //String[] listForms = {"keySkillsMasterList","countryMasterList"}; 
    //MasterEntity.MasterDataType[] entityTypes = {MasterEntity.MasterDataType.KEYSKILLS,MasterEntity.MasterDataType.COUNTRY};
    MasterEntity[] objMaster = {null,new Keyskills(),new Country(),new AnalystPreference(),new CompanyTitle(),new CompanyType(),
    		                        new Currency(),new Industry(),new Occupation(),new ResearchType(),new TurnAroundTime(),
    		                        new Units(),new UpdateCycle()};
    
    private static final Logger logger = Logger.getLogger(MasterController.class);
    
    public MasterController() {
        System.out.println("MasterController()");
    }

    @Autowired
    private MasterService masterService;

    /*@RequestMapping("createMaster")
    public ModelAndView createMaster(@RequestParam Integer typeid) {
    	MasterEntity master = objMaster[typeid.intValue()];
    	ModelAndView modelAndView = new ModelAndView(createForms[typeid]);
    	modelAndView.addObject("master", master);
    	modelAndView.addObject("typeid", typeid);
        logger.info("Creating Master. Data: "+master);
        return modelAndView;
    }*/
    
    @RequestMapping(value="editMaster",method=RequestMethod.POST)
    public String editMaster(@RequestParam MasterEntity newmaster,@RequestParam Integer typeid) {
        logger.info("Updating the Master for the Id "+typeid);
        /*MasterEntity master = masterService.findById(id);
        ModelAndView modelAndView = new ModelAndView(createForms[typeid]);
    	modelAndView.addObject("master", master);
    	modelAndView.addObject("typeid", typeid);
    	modelAndView.addObject("id", id);*/
        masterService.save(newmaster);
        return "redirect:getAllMasters?masterType="+typeid;
    }
    
    @RequestMapping(value="loadMaster",produces = "application/json")
    public @ResponseBody MasterEntity loadMaster(@RequestParam Integer typeid,@RequestParam Integer id) {
        logger.info("Updating the Master for the Id "+id);
        MasterEntity master = masterService.findById(id);
        return master;
    }
    
    @RequestMapping("saveMaster")
    public @ResponseBody String saveMaster(@RequestParam Integer typeid,WebRequest request) {
    	MasterEntity domainObject=null;
		try {
			Class c= MasterDataType.getMasterDomainClassById(typeid.intValue());
			domainObject = (MasterEntity) MasterDataType.getMasterDomainClassById(typeid.intValue()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
    	//domainObject.setMasterDataType(entityTypes[typeid]);
    	WebRequestDataBinder binder = new WebRequestDataBinder(domainObject);
    	binder.bind(request);
    	System.out.println(domainObject);
        logger.info("Saving the Master. Data : "+domainObject);
        masterService.save(domainObject);
        return "Master Entity Created Successfully ";
    }
    
    @RequestMapping("deleteMaster")
    public @ResponseBody String deleteMaster(@RequestParam Integer typeid,@RequestParam Integer id) {
        logger.info("Deleting the Master. Id : "+id);
        masterService.delete(id);
        return "Master Entity Deleted Successfully";
    }
    
    
    
    @RequestMapping(value = {"getAllMasters", "/"},produces = "application/json")
    public @ResponseBody List<MasterEntity> getAllMasters(HttpServletRequest request,@RequestParam Integer masterType) {
    	//Integer masterType = 0 ;
        logger.info("Getting the all Masters.");
        List<MasterEntity> masterList = masterService.findByMasterDataType(MasterDataType.getMasterDataType(masterType.intValue()));
        //ModelAndView view = new ModelAndView(listForms[masterType.intValue()], "masterList", masterList);
        //view.addObject("typeid", masterType);
        logger.info("returning json of " + masterList);
        return masterList;
    }
    
    @RequestMapping(value = {"mastershome", "/"})
    public ModelAndView mastershome() {
        logger.info("Loading Masters Home.");
        return new ModelAndView("mastershome");
    }
    
    @RequestMapping("searchMaster")
    public ModelAndView searchMaster(@RequestParam("searchName") String searchName) {  
        logger.info("Searching the Master. Master Names: "+searchName);
        List<MasterEntity> masterList = null;// masterService.findAll(searchName);
        return new ModelAndView("masterList", "masterList", masterList);      
    }
}
