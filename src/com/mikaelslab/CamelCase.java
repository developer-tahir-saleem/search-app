package com.mikaelslab;

import static com.mikaelslab.utils.Utils.isAllUpper;

public class CamelCase {
    public String keySearch;
    public String welcome(String pass){
        System.out.println("Start CamelCase : " + pass);
        return pass;
    }
    public CamelCase(String input) {
        this.keySearch = input;
    }

    public boolean isCamelCaseSearch(String pattern) {
        return (isAllUpper(this.keySearch) && pattern.equalsIgnoreCase("camel-case"));
    }
}
