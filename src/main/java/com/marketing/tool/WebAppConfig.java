package com.marketing.tool;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  
@EnableWebMvc  
public class WebAppConfig extends WebMvcConfigurerAdapter {
	 @Override  
     public void addResourceHandlers(ResourceHandlerRegistry registry) {             
             registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");  
             registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");  
             registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/"); 
             registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/fonts/"); 
             registry.addResourceHandler("/tree/**").addResourceLocations("classpath:/tree/"); 
     }  
}
