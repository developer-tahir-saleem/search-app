package com.mikaelslab;

import com.mikaelslab.utils.FileFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mikaelslab.utils.Utils.isAllUpper;
import static com.mikaelslab.utils.Utils.isCaseSensitive;

public class SensitiveCase {

    public String welcome(String pass){
        System.out.println("Start SensitiveCase : " + pass);
        return pass;
    }

    public boolean isSensitiveCaseSearch(String input) {
        return isCaseSensitive(input);
    }

    public List<String> find(String input, FileFinder files) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry me : files.files.entrySet()) {
            String[] reItem = me.getValue().toString().split("\\s+");
            if (isAllUpper(input)){
                if (me.getValue().toString().toLowerCase().contains(input)) {
                    result.add(reItem[0] + " - " + me.getKey());
                }
            }else {
                if (me.getValue().toString().toLowerCase().contains(input)) {
                    result.add(reItem[0] + " - " + me.getKey());
                }

            }

        }
    return result;
    }

}
