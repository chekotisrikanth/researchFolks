package com.marketing.tool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
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
	 
	 
	 /*@Bean
	    public FormattingConversionService conversionService() {

	        // Use the DefaultFormattingConversionService but do not register defaults
	        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

	        // Ensure @NumberFormat is still supported
	        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

	        // Register date conversion with a specific global format
	        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
	        registrar.setFormatter(new DateFormatter("MM/dd/yyyy"));
	        registrar.registerFormatters(conversionService);

	        return conversionService;
	    }
	 
	 @Override
	    public void addFormatters(FormatterRegistry registry) {
	      
	        registry.addFormatter(new DateFormatter("MM/dd/yyyy"));
	    }
*/
	 @Override
	    public void addFormatters(FormatterRegistry registry) {
	      
	        registry.addFormatter(new DateFormatter("MM-dd-yyyy"));
	    }
	 
}
