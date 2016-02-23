package com.marketing.tool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.marketing.tool.domain.Admin;
import com.marketing.tool.domain.AdminCreateForm;

@Component
public class IntegerValidator implements Validator {

	 @Override
	    public boolean supports(Class<?> clazz) {
	        return Integer.class.isAssignableFrom(clazz);
	    }

	    @Override
	    public void validate(Object target, Errors errors) {
	    	Integer form = (Integer) target;
	      /*  if (!form.getPassword1().equals(form.getPassword2())) {
	            errors.rejectValue("password2", "user.error.password.no_match");
	        }*/
	    }
}
