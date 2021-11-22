package com.mikaelslab;

import static com.mikaelslab.utils.Utils.isAllUpper;

public class SensitiveCase {
    public String keySearch;
    public String welcome(String pass){
        System.out.println("Start SensitiveCase : " + pass);
        return pass;
    }
    public SensitiveCase(String input) {
        this.keySearch = input;
    }

    public boolean isSensitiveCaseSearch(String pattern) {
        return (isAllUpper(this.keySearch) && pattern.equalsIgnoreCase("sensitive-case"));
    }
}
