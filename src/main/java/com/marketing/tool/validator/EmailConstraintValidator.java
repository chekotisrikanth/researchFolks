package com.marketing.tool.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<Email, String>{
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	@Override
	public void initialize(Email String) {
		
	}

	@Override
	public boolean isValid(String emailField, ConstraintValidatorContext cxt) {
		if(emailField == null)
			return false;
		Pattern p =  Pattern.compile(EMAIL_PATTERN);
		Matcher m = p.matcher(emailField);
		 return m.find();
	}

}
