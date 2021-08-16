package com.margin.common.exception;

public enum ExceptionCode {
    UUTI_45 (ExceptionType.ERROR),
    YUTI_67(ExceptionType.WARNING),
    ;

    private ExceptionType type;

    ExceptionCode(ExceptionType type) {
        this.type = type;
    }
}
