package com.mikaelslab;


import com.mikaelslab.utils.FileFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mikaelslab.utils.Utils.isWildCard;
import static com.mikaelslab.utils.Utils.splitWildCard;

public class WildCardCase {


    public boolean isWildCardPSearch(String input) {
        return isWildCard(input);
    }

    public String welcome(String pass) {
        System.out.println("Start WildCardCase : " + pass);
        return pass;
    }

    public List<String> find(String input, FileFinder files){
        List<String> result = new ArrayList<String>();
        List<String> searchKeyWlidCard = splitWildCard(input);
        searchKeyWlidCard.forEach(x -> {
            for (Map.Entry me : files.files.entrySet()) {
                String[] reItem = me.getValue().toString().split("\\s+");

                if (me.getValue().toString().contains(x) && input.contains("*")) {

                    result.add(reItem[0] + " - " + me.getKey());
                }
//                        System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
            }
        });
        return result;
    }

}
