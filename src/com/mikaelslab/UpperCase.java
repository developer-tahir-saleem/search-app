package com.mikaelslab;

import static com.mikaelslab.utils.Utils.isAllUpper;

public class UpperCase {

    public String keySearch;
    public String welcome(String pass){
        System.out.println("Start UpperCase : " + pass);
        return pass;
    }
    public UpperCase(String input) {
        this.keySearch = input;
    }

    public boolean isUpperCaseSearch(String pattern) {
        return (isAllUpper(this.keySearch) && pattern.equalsIgnoreCase("upper-case"));
    }

}
