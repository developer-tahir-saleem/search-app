package com.mikaelslab;

import com.mikaelslab.utils.FileFinder;
import com.mikaelslab.utils.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mikaelslab.utils.Utils.*;

public class Main {

    public static void main(String[] args) {
        Request req = new Request(args);
        if (req.isValidParam() && req.isValidPath() && req.isValidKeyword() && req.isValidPattern()) {
            FileFinder files = new FileFinder(args[0]);
            List<String> result = new ArrayList<>();
            List<String> searchKeyCamelCase = splitCamelCase(args[1].toString());

            if (args[2].toString().equalsIgnoreCase("wild-card")) {
                WildCardCase wcc = new WildCardCase();
                if (wcc.isWildCardPSearch(args[1])){
                    result = wcc.find(args[1], files);
                }else {
                    System.out.println("Search Pattern wild-card not Match!");
                }
            } else if (isAllUpper(args[1].toString())) {
                for (Map.Entry me : files.files.entrySet()) {
                    if (me.getValue().toString().contains(args[1])) {
                        String[] reItem = me.getValue().toString().split("\\s+");
                        result.add(reItem[0] + " - " + me.getKey());
                    }
//                        System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
                }
            } else if (searchKeyCamelCase.size() > 0) {
                //            System.out.println(searchKey);
                System.out.println(files.files);

//                searchKeyCamelCase.forEach(x -> {
//                    for (Map.Entry me : files.files.entrySet()) {
//                        String[] reItem = me.getValue().toString().split("\\s+");
//                        if (args[1].length() == me.getValue().toString().length() || args[1].length() < me.getValue().toString().length()) {
//                            if (me.getValue().toString().contains(args[1])) {
//
//                                result.add(reItem[0] + " - " + me.getKey());
//                            }
//                        } else {
//                            if (me.getValue().toString().contains(x)) {
//                                result.add(reItem[0] + " - " + me.getKey());
//                            }
//                        }
////                        System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
//                    }
//                });

            } else if (isCaseSensitive(args[1].toString())) {

                for (Map.Entry me : files.files.entrySet()) {
                    String[] reItem = me.getValue().toString().split("\\s+");
                    if (me.getValue().toString().contains(args[1].toString().toUpperCase())) {
                        result.add(reItem[0] + " - " + me.getKey());
                    }
                }
            } else {
                System.out.println("Pattern not match ");
            }
            result.stream().distinct()
                    .collect(Collectors.toList()).forEach(x -> System.out.println(x));
//            System.out.println(splitCamelCase("abcDelDAOsaDAs"));
//
//            System.out.println("Program Is working ");


//       ClassA cal = new ClassA();
//       ClassB calB = new ClassB();
//        System.out.println("End Class A : " +calA.welcome("One"));
//        System.out.println("End Class B : " +calB.welcome("Two"));
//	// write your code here

//
//                System.out.println(ff.files.toString());
        }
    }
}
