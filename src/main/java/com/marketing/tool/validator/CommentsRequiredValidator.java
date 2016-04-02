package com.marketing.tool.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CommentsRequiredValidator implements ConstraintValidator<CommentsValidators, String>{
	

	@Override
	public boolean isValid(String commentsFiled, ConstraintValidatorContext cxt) {
		
		return true;
	}

	@Override
	public void initialize(CommentsValidators arg0) {
		// TODO Auto-generated method stub
		
	}

}
