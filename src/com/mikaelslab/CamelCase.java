package com.mikaelslab;

import com.mikaelslab.utils.FileFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mikaelslab.utils.Utils.splitCamelCase;

public class CamelCase {

    public String welcome(String pass) {
        System.out.println("Start CamelCase : " + pass);
        return pass;
    }


    public boolean isCamelCaseSearch(String input) {
        if (splitCamelCase(input).size() > 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> find(String input, FileFinder files) {
        List<String> searchKeyCamelCase = splitCamelCase(input);
        HashMap<String, String> item = new HashMap<>();

        List<String> result = new ArrayList<String>();
                        searchKeyCamelCase.forEach(x -> {
                    for (Map.Entry me : files.files.entrySet()) {
                        String[] reItem = me.getValue().toString().split("\\s+");
                        if (input.length() >= reItem[0].length() ) {
                            if (input.contains(reItem[0])) {
                                result.add(reItem[0] + " - " + me.getKey());
                            }
                        } else {
                            if (me.getValue().toString().contains(x)) {
                                result.add(reItem[0] + " - " + me.getKey());
                            }
                        }
                    }
                });
        return result;
    }
}
