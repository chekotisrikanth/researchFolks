package com.marketing.tool.utility;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.QAuthor;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.annotations.QueryDelegate;
import com.mysema.query.types.Predicate;

public class AuthorQueryDelegate {

	@QueryDelegate(Author.class)
	 public static Predicate startsWithIgnoreCase(QAuthor entity, String value) {
	     BooleanBuilder builder = new BooleanBuilder(); 
	     if (value != null) {
	         builder.and(entity.firstName.eq(value));
	     }
	     return builder.getValue();
	 }
	 
}
