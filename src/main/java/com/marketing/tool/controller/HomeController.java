package com.marketing.tool.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marketing.tool.domain.User;
import com.marketing.tool.utility.Helper;

@Controller
public class HomeController {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	Helper helper;
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public void homePage(HttpServletRequest request, 
		      HttpServletResponse response) throws IOException {
		String url="/public/home";
		User loginUser = helper.getPrincipalUser();
		if(loginUser!=null) {
			url = Helper.getHomePageURL(loginUser.getAccountType());
		}
		redirectStrategy.sendRedirect(request, response, url);
	}
	
	@RequestMapping(value = { "/","/public/home"}, method = RequestMethod.GET)
	public String publicHomePage(HttpServletRequest request, 
		      HttpServletResponse response) throws IOException {
		return "homepage";
	}
}
