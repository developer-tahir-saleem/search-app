package com.mikaelslab.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static boolean isCamelCase(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if (numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }


    public static String seprateCamelCase(String s) {
        char ch = 0;
        StringBuilder str = new StringBuilder();
        if (s == null) {
            return s;
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                if (Character.isUpperCase(ch)) {
                    str.append(s.charAt(i));
                } else {
                    str.append(" " + s.charAt(i));
                }
            } else {
                str.append(s.charAt(i));
            }
            ch = s.charAt(i);
        }
        return str.toString();
    }

    public static List<String> splitCamelCase(String s) {
        char ch = 0;
        List<String> list = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        if (s == null) {
            return Arrays.asList(s);
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                if (Character.isUpperCase(ch)) {
                    str.append(" "+s.charAt(i));
                } else {
                    str.append(" " + s.charAt(i));
                }
            } else {
                str.append(s.charAt(i));
            }
            ch = s.charAt(i);
        }
        String[] splited = str.toString().split("\\s+");

        for (String sitem : splited)
            if (!sitem.equals(""))
                list.add(sitem);
        return list;
    }

    public static List<String> splitWildCard(String s) {
        char CharacterToFind = '*';
        List<String> list = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        if (s == null) {
            return Arrays.asList(s);
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i)==CharacterToFind) {
                str.append(" ");
            }else {
                str.append(s.charAt(i));
            }

        }
        String[] splited = str.toString().split("\\s+");

        for (String sitem : splited)
            if (!sitem.equals(""))
                list.add(sitem);
        return list;
    }

    public static boolean isAllUpper(String s) {
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c) && Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCaseSensitive(String input){
        if (isAllUpper(input)){
            return input.toUpperCase().contains(input);
        }else {
            return input.toLowerCase().contains(input);

        }
    }

    public static boolean isWildCard(String input){
            return input.contains("*");
    }


    }
