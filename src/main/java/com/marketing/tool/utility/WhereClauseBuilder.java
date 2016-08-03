package com.marketing.tool.utility;

import java.util.function.Function;

import javax.annotation.Nullable;

import com.marketing.tool.domain.QAuthor;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.Visitor;
import com.mysema.query.types.expr.BooleanExpression;


public class WhereClauseBuilder implements Predicate, Cloneable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BooleanBuilder delegate;

    public WhereClauseBuilder()
    {
        this.delegate = new BooleanBuilder();
    }

    public WhereClauseBuilder(Predicate pPredicate)
    {
        this.delegate = new BooleanBuilder(pPredicate);
    }

    public WhereClauseBuilder and(Predicate right)
    {
        return new WhereClauseBuilder(delegate.and(right));
    }

   
    public WhereClauseBuilder or(Predicate right)
    {
    	
        return new WhereClauseBuilder(delegate.or(right));
    }

    public <V> WhereClauseBuilder optionalAnd(@Nullable V pValue, LazyBooleanExpression pBooleanExpression)
    {
        return applyIfNotNull(pValue, this::and, pBooleanExpression);
    }
    
    public <V> WhereClauseBuilder optionalOr(@Nullable V pValue, LazyBooleanExpression pBooleanExpression)
    {
        return applyIfNotNull(pValue, this::or, pBooleanExpression);
    }

    private <V> WhereClauseBuilder applyIfNotNull(@Nullable V pValue, Function<Predicate, WhereClauseBuilder> pFunction, LazyBooleanExpression pBooleanExpression)
    {
        if (pValue != null)
        {
            return new WhereClauseBuilder(pFunction.apply(pBooleanExpression.get()));
        }

        return this;
    }

    @Override
    public <R,C> R accept(Visitor<R,C> v, C context) {
        if (this.delegate.getValue() != null) {
            return this.delegate.getValue().accept(v, context);
        } else {
            return null;
        }
    }

    @Override
    public Class<? extends Boolean> getType() {
        return Boolean.class;
    }
    
    @Override
    public BooleanBuilder not() {
    	Predicate  predicate = this.delegate.getValue();
        if (predicate != null) {
            predicate = predicate.not();
        }
        return this.delegate;
    }
    	public static void main(String[] args) {
		QAuthor qauthor = QAuthor.author;
		WhereClauseBuilder predicate2 = new WhereClauseBuilder().optionalAnd("anil", () -> qauthor.lastName.startsWithIgnoreCase("anil"));
		System.out.println(predicate2);
	}

	
   }

    
