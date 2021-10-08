package com.margin.common.exception.response;

public enum ExceptionCode {
    UUTI_45(ExceptionType.ERROR),
    YUTI_67(ExceptionType.WARNING);

    private final ExceptionType type;

    ExceptionCode(ExceptionType type) {
        this.type = type;
    }

    public ExceptionType getType() {
        return type;
    }
}
