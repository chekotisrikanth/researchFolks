package com.marketing.tool.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
 
@Service
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  private static Logger logger = LoggerFactory.getLogger("SuccessHandler");
 
   
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
      HttpServletResponse response, Authentication authentication)
      throws ServletException, IOException {
	  request.getSession().setMaxInactiveInterval(60*15);
    String referrer = request.getParameter("referrer");
    logger.info("onAuthenticationSuccess " + referrer);
    if("loginlink".equalsIgnoreCase(referrer)) {
    	handle(request, response, authentication);
    } else {
    	super.onAuthenticationSuccess(request, response, authentication);
    }
    
  }
  
  protected void handle(HttpServletRequest request, 
	      HttpServletResponse response, Authentication authentication) throws IOException {
	        String targetUrl = determineTargetUrl(authentication);
	        
	        if (response.isCommitted()) {
	            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
	            return;
	        }
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }
	 
	    /** Builds the target URL according to the logic defined in the main class Javadoc. */
	    protected String determineTargetUrl(Authentication authentication) {
	        boolean isUser = false;
	        boolean isAdmin = false;
	        boolean isAuthor = false;
	        boolean isReviewer = false;
	        boolean isPublisher = false;
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        for (GrantedAuthority grantedAuthority : authorities) {
	            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
	                isUser = true;
	                break;
	            } else if (grantedAuthority.getAuthority().equals("ROLE_REVIEWER")) {
	            	isReviewer = true;
	                break;
	            }else if (grantedAuthority.getAuthority().equals("ROLE_PUBLISHER")) {
	            	isPublisher = true;
	                break;
	            }
	            else if (grantedAuthority.getAuthority().equals("ROLE_AUTHOR")) {
	            	isAuthor = true;
	                break;
	            }
	            else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
	                isAdmin = true;
	                break;
	            }
	        }
	 
	        if (isUser) {
	        	return "/secure/home/customerhome";
	        } else if (isAdmin) {
	            //return "/secure/home/admin";
	        	return "/secure/home/admin/0/10";
	        } else if(isAuthor) {
	        	return "/author/home/authorhome";
	        } else if(isReviewer) {
	        	return "/secure/home/reviewer/0/10";
	        }else if(isPublisher) {
	        	return "/secure/home/publisher/0/10";
	        }else {
	        	return "/secure/home/homepage.html";
	        }
	    }
	 	 
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }
	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }
}