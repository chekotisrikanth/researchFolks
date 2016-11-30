package com.marketing.tool;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.marketing.tool.handler.SuccessHandler;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

@ComponentScan
@Configuration
@EnableAutoConfiguration
//@EnableAdminServer
@SpringBootApplication
@EnableSpringDataWebSupport

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class Application extends SpringBootServletInitializer {
	

	@Autowired
    DataSourceProperties dataSourceProperties;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource realDataSource() {
		DataSource dataSource =DataSourceBuilder
                .create ( this.dataSourceProperties.getClassLoader ())
                .url ( this.dataSourceProperties.getUrl ())
                .username ( this.dataSourceProperties.getUsername ())
                .password ( this.dataSourceProperties.getPassword ())
                .build ();
        return new Log4jdbcProxyDataSource(dataSource); 
    }
	
	
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    @Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
   
    /*@Bean
    public CommonsMultipartResolver multipartResolve() {
    	CommonsMultipartResolver res = new CommonsMultipartResolver();
		res.setMaxUploadSize(-1);;
    	return res;
    }
    */
    
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(-1);
        factory.setMaxRequestSize(-1);
        return factory.createMultipartConfig();
    }
    
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private DataSource dataSource;
		
		@Autowired
	    private UserDetailsService userDetailsService;
		
		@Autowired
		private SuccessHandler successHandler;

	   /* //@Autowired
	    private PasswordEncoder passwordEncoder;*/
		
		 

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			/*http.authorizeRequests().antMatchers("/public/**").permitAll();.anyRequest()
					.fullyAuthenticated().and().formLogin().loginPage("/loginPage")
					.failureUrl("/loginPage?error").permitAll().and().logout().permitAll();
			
			//http.authorizeRequests().antMatchers("/public/author_create.html").permitAll().anyRequest().fullyAuthenticated();
			http.authorizeRequests().antMatchers("/publish/**").access("hasRole('PUBLISHER')")
			//.antMatchers("/dba/**").access("hasRole('ADMIN') or hasRole('DBA')")
			.and().formLogin().successHandler(loginAuthenticationSuccessHandler);*/
			
			  http.authorizeRequests()
			  	.antMatchers("/public/**", "/home").permitAll()
			  	.antMatchers("/css/**").permitAll()
			  	.antMatchers("/tree/assets/").permitAll()
			  	.antMatchers("/freefolk/**", "/home").permitAll()
			  	.antMatchers("/console/**").permitAll()
			  	.antMatchers("/*/purchase/**").access("hasRole('USER')")
			  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
			  	//.antMatchers("/secure/master/**").access("hasRole('ADMIN')")
			  	.antMatchers("/publish/**").access("hasRole('AUTHOR')")
			  	.antMatchers("/author/**").access("hasRole('AUTHOR')")
			  	.antMatchers("/comments/**").access("hasRole('REVIEWER') or hasRole('AUTHOR')")
			  	.antMatchers("/downloadReport/**").access("hasRole('ADMIN') or hasRole('PUBLISHER') or hasRole('REVIEWER') or hasRole('AUTHOR')")
			  	//.antMatchers("/secure/**").access("hasRole('ADMIN') or hasRole('PUBLISHER') or hasRole('REVIEWER')")
			  	.and().formLogin().loginPage("/public/login").loginProcessingUrl("/j_spring_security_check").successHandler(successHandler)
			  	.usernameParameter("emailId").passwordParameter("password")
			  	.and().csrf()
			  	.and().exceptionHandling().accessDeniedPage("/public/access_denied");
			  
			  http.csrf().disable();
			  http.headers().frameOptions().disable();
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			//auth.jdbcAuthentication().dataSource(this.dataSource);
			auth.userDetailsService(userDetailsService);
		}

	}

  }
