package com.mikaelslab.utils;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.mikaelslab.utils.Message.MS_REQUEST_PARAM_COUNT;
import static com.mikaelslab.utils.Message.MS_REQUEST_VALID_PATH;

public class Request implements Validation {

    private String[] arg;

    public Request(String[] arg) {
        this.arg = arg;
    }

    @Override
    public boolean isValidParam() {
        FunInter checkarg = (a) -> a.length == 3;
        return this.showMessage(checkarg.apply(this.arg), MS_REQUEST_PARAM_COUNT);
    }

    @Override
    public boolean isValidPath() {
        FunInter checkStartWithDecimal = (a) -> a[0].startsWith(".");
        boolean checkContainCharacter = Stream.of( ":","?","\"","<",">","*","..." ).anyMatch(x -> this.arg[0].contains(x));
        boolean checkStart = checkStartWithDecimal.apply(this.arg);
        return this.showMessage((checkContainCharacter && checkStart),MS_REQUEST_VALID_PATH);
    }

    @Override
    public boolean isValidKeyword() {
        return false;
    }

    @Override
    public boolean isValidPattern() {
        return false;
    }

    @Override
    public boolean showMessage(boolean value, String message) {
        if (!value)
            System.out.println(message);
        return value;
    }
}
