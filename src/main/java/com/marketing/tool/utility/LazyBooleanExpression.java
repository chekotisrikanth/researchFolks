package com.marketing.tool.utility;

import com.mysema.query.types.expr.BooleanExpression;

@FunctionalInterface
public interface LazyBooleanExpression
{
    BooleanExpression get();
}
