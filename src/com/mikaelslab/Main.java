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
            if (args[2].toString().equalsIgnoreCase("wild-card")) {
                WildCardCase wcc = new WildCardCase();
                if (wcc.isWildCardPSearch(args[1])) {
                    result = wcc.find(args[1], files);
                } else {
                    System.out.println("Search Pattern wild-card not Match!");
                }
            } else if (args[2].toString().equalsIgnoreCase("upper-case")) {
                UpperCase upperCase = new UpperCase();
                if (upperCase.isUpperCaseSearch(args[1])) {
                    result = upperCase.find(args[1], files);
                } else {
                    System.out.println("Search Pattern upper-case not Match!");
                }
            } else if (args[2].toString().equalsIgnoreCase("camel-case")) {
                CamelCase camelCase = new CamelCase();
                if (camelCase.isCamelCaseSearch(args[1])) {
                    result = camelCase.find(args[1], files);
                } else {
                    System.out.println("Search Pattern camel-case not Match!");
                }
            } else if (args[2].toString().equalsIgnoreCase("sensitive-case")) {
              SensitiveCase sensitiveCase = new SensitiveCase();
                if (sensitiveCase.isSensitiveCaseSearch(args[1])) {
                    result = sensitiveCase.find(args[1], files);
                } else {
                    System.out.println("Search Pattern sensitive-case not Match!");
                }
            } else {
                System.out.println("Pattern not match ");
            }
            result.stream().distinct()
                    .sorted()
                    .collect(Collectors.toList()).forEach(x -> System.out.println(x));

        }
    }
}
