package com.marketing.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class EndpointDocController {

	/*
	 * @Autowired private ListableBeanFactory listableBeanFactory;
	 */

	@Autowired
	@Qualifier("requestMappingHandlerMapping")
	private RequestMappingHandlerMapping handlerMapping;

	@RequestMapping(value = "/endpointsinfo", method = RequestMethod.GET)
	public void show(Model model) {
		// Map<String, Object> controllers;
		// controllers =
		// listableBeanFactory.getBeansWithAnnotation(Controller.class);
		model.addAttribute("handlerMethods", this.handlerMapping.getHandlerMethods());
	}
}
