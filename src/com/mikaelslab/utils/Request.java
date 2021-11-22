package com.mikaelslab.utils;

import java.util.stream.Stream;

import static com.mikaelslab.utils.Message.*;

public class Request implements Validation {

    private String[] arg;

    public Request(String[] arg) {
        this.arg = arg;
    }

    @Override
    public boolean isValidParam() {
        FunctionalInterface checkargument = (a) -> a.length == 3;
        return this.showMessage(checkargument.apply(this.arg), MS_REQUEST_PARAM_COUNT);
    }

    @Override
    public boolean isValidPath() {
        FunctionalInterface checkStartWithDecimal = (a) -> a[0].startsWith(".");
        boolean checkContainCharacter = Stream.of(":", "?", "\"", "<", ">", "*", "...").noneMatch(x -> this.arg[0].contains(x));
        boolean checkStart = checkStartWithDecimal.apply(this.arg);
        return this.showMessage((checkContainCharacter && checkStart), MS_REQUEST_VALID_PATH);
    }

    @Override
    public boolean isValidKeyword() {
//        Illegal Filename Characters
        return this.showMessage(
                Stream.of("`", "+", "=", "|", ",", "#", "@", "'", "!", "$", "/", "[", "]", "}", "{", "&", "%", ":", "?", "\"", "<", ">", "...")
                        .noneMatch(x -> this.arg[1].contains(x)), MS_REQUEST_VALID_ILLEGALCHARACTER);
    }

    @Override
    public boolean isValidPattern() {
        return this.showMessage(
                Stream.of("camel-case", "lower-case", "upper-case","sensitive-case", "wild-card", "last-space")
                        .anyMatch(x -> this.arg[2].contains(x)), MS_REQUEST_VALID_PATTERN);
    }

    @Override
    public boolean showMessage(boolean value, String message) {
        if (!value)
            System.out.println(message);
        return value;
    }
}
