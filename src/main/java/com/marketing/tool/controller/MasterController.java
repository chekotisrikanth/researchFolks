package com.marketing.tool.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.MasterEntity;
import com.marketing.tool.service.MasterService;

@Controller
@RequestMapping("/secure/master/")
public class MasterController<T> {
	
    String[] createForms = {"keySkillsMaster","countryMaster"}; 
    String[] listForms = {"keySkillsMasterList","countryMasterList"}; 
    MasterEntity.MasterDataType[] entityTypes = {MasterEntity.MasterDataType.KEYSKILLS,MasterEntity.MasterDataType.COUNTRY};
    MasterEntity[] objMaster = {new Keyskills(),new Country()};
    
    
    private static final Logger logger = Logger.getLogger(MasterController.class);
    
    public MasterController() {
        System.out.println("MasterController()");
    }

    @Autowired
    private MasterService masterService;

    @RequestMapping("createMaster")
    public ModelAndView createMaster(@RequestParam Integer typeid) {
    	MasterEntity master = objMaster[typeid.intValue()];
    	ModelAndView modelAndView = new ModelAndView(createForms[typeid]);
    	modelAndView.addObject("master", master);
    	modelAndView.addObject("typeid", typeid);
        logger.info("Creating Master. Data: "+master);
        return modelAndView;
    }
    
    @RequestMapping("editMaster")
    public ModelAndView editMaster(@RequestParam Integer typeid,@RequestParam Integer id) {
        logger.info("Updating the Master for the Id "+id);
        MasterEntity master = masterService.findById(id);
        ModelAndView modelAndView = new ModelAndView(createForms[typeid]);
    	modelAndView.addObject("master", master);
    	modelAndView.addObject("typeid", typeid);
    	modelAndView.addObject("id", id);
        return modelAndView;
    }
    
    @RequestMapping("saveMaster")
    public ModelAndView saveMaster(@RequestParam Integer typeid,@RequestParam Integer id, WebRequest request) {
    	MasterEntity domainObject = objMaster[typeid.intValue()];
    	if(id!=null) {
    		domainObject.setId(id);
    	}
    	domainObject.setMasterDataType(entityTypes[typeid]);
    	WebRequestDataBinder binder = new WebRequestDataBinder(domainObject);
    	binder.bind(request);
    	System.out.println(domainObject);
        logger.info("Saving the Master. Data : "+domainObject);
        masterService.save(domainObject);
       
        return new ModelAndView("redirect:getAllMasters?typeid="+typeid);
    }
    
    @RequestMapping("deleteMaster")
    public ModelAndView deleteMaster(@RequestParam Integer typeid,@RequestParam Integer id) {
        logger.info("Deleting the Master. Id : "+id);
        masterService.delete(id);
        return new ModelAndView("redirect:getAllMasters?typeid="+typeid);
    }
    
    @RequestMapping(value = {"getAllMasters", "/"})
    public ModelAndView getAllMasters(@RequestParam Integer typeid) {
        logger.info("Getting the all Masters.");
        List<MasterEntity> masterList = masterService.findByMasterDataType(entityTypes[typeid]);
        ModelAndView view = new ModelAndView(listForms[typeid.intValue()], "masterList", masterList);
        view.addObject("typeid", typeid);
        return view;
    }
    
    @RequestMapping("searchMaster")
    public ModelAndView searchMaster(@RequestParam("searchName") String searchName) {  
        logger.info("Searching the Master. Master Names: "+searchName);
        List<MasterEntity> masterList = null;// masterService.findAll(searchName);
        return new ModelAndView("masterList", "masterList", masterList);      
    }
}
