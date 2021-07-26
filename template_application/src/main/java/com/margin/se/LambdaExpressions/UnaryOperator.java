package com.margin.se.LambdaExpressions;

public interface UnaryOperator<T> extends Function<T, T> {
    T apply(T t);
}
