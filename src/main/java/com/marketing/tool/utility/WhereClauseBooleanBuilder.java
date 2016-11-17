package com.marketing.tool.utility;

import java.util.function.Function;

import javax.annotation.Nullable;

import com.marketing.tool.domain.QAuthor;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.StringPath;


public class WhereClauseBooleanBuilder
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BooleanBuilder delegate=new BooleanBuilder();

	EntityPathBase entity;
	
	public WhereClauseBooleanBuilder(EntityPathBase entity) {
		this.entity = entity;
	}
	
    public WhereClauseBooleanBuilder()
    {
        this.delegate = new BooleanBuilder();
    }

    public WhereClauseBooleanBuilder(Predicate pPredicate)
    {
        this.delegate = new BooleanBuilder(pPredicate);
    }


	public WhereClauseBooleanBuilder and(WhereClauseBooleanBuilder right)
    {
        return new WhereClauseBooleanBuilder(delegate.and(right.delegate));
    }

   /* public WhereClauseBuilder startsWithIgnoreCase(Predicate right)
    {
        return new WhereClauseBuilder(delegate.startsWithIgnoreCase(right));
    }
*/
    public WhereClauseBooleanBuilder or(Predicate right)
    {
        return new WhereClauseBooleanBuilder(delegate.or(right));
    }

   /* public <V> WhereClauseBooleanBuilder optionalAnd(@Nullable V pValue, LazyBooleanExpression pBooleanExpression)
    {
        return applyIfNotNull(pValue, this::and, pBooleanExpression);
    }
*/
  /*  public <V> WhereClauseBuilder optionalStartsWithIgnoreCase(@Nullable V pValue, LazyBooleanExpression pBooleanExpression)
    {
        return applyIfNotNull(pValue, this::startsWithIgnoreCase, pBooleanExpression);
    }

*/    
    private <V> WhereClauseBooleanBuilder applyIfNotNull(@Nullable V pValue, Function<Predicate, WhereClauseBooleanBuilder> pFunction, LazyBooleanExpression pBooleanExpression)
    {
        if (pValue != null)
        {
            return new WhereClauseBooleanBuilder();
        }

        return this;
    }
    
    public static WhereClauseBooleanBuilder startsWithIgnoreCaseIfNotNull(String filedname,String value) {
		if(value!=null) {
			return new WhereClauseBooleanBuilder(new StringPath(QAuthor.author, filedname).startsWithIgnoreCase(value));
		}else {
			return new WhereClauseBooleanBuilder();
		}
   	}
    
   /* public static void main(String[] args) {
    	WhereClauseBooleanBuilder b = startsWithIgnoreCaseIfNotNull("firstName",null).and(startsWithIgnoreCaseIfNotNull("lastName", "Anil"));
       System.out.println(b);
    }*/
}
    
