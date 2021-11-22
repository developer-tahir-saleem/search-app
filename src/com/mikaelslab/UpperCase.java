package com.mikaelslab;

import com.mikaelslab.utils.FileFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mikaelslab.utils.Utils.isAllUpper;

public class UpperCase {


    public String welcome(String pass) {
        System.out.println("Start UpperCase : " + pass);
        return pass;
    }

    public boolean isUpperCaseSearch(String input) {
        return (isAllUpper(input));
    }

    public List<String> find(String input, FileFinder files) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry me : files.files.entrySet()) {
            if (me.getValue().toString().contains(input)) {
                String[] reItem = me.getValue().toString().split("\\s+");
                result.add(reItem[0] + " - " + me.getKey());
            }
        }
        return result;
    }

}
