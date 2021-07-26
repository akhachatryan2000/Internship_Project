package com.margin.se.LambdaExpressions;

public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    T applyBinary(T t, T t1);
}
