package com.mikaelslab.utils;

import java.util.Optional;
import java.util.function.IntFunction;

public interface Validation {
    public boolean isValidParam();
    public boolean isValidPath();
    public boolean isValidKeyword();
    public boolean isValidPattern();
    public boolean showMessage(boolean value, String message);

}
