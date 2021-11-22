package com.mikaelslab.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class FileFinder {
    public Map<String, String> files;

    public FileFinder(String path) {
        try {
            this.files = Files.find(Paths.get(path),
                            Integer.MAX_VALUE,
                            (filePath, fileAttr) -> fileAttr.isRegularFile())
                    .collect(Collectors.toMap(e -> removefileExtention(e.toString()
                                    .replace("/", ".")).replace("..","").replace("...",""),
                            e -> {
                                String fname = getFileName(e.getFileName().toString());
                                return fname + " || " + getAllUppercase(fname) + " || " + Utils.seprateCamelCase(fname)+" ";
                            }));
//                    .forEach(x -> result.put(x.toString(),x.toString()));
        } catch (IOException ioe) {
            System.out.println("dd" + ioe.getMessage());
        }
//        System.out.println(getFileName("teste.txt"));
//        List<String> list = Arrays.asList("abcDelDAO");
//        list.stream()
//                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
//                .sorted(Comparator.comparingInt(String::length))
//                .forEach(System.out::println);
//                .forEachOrdered(n -> System.out.println(n));
    }

    public String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public String getFileName(String input) {
        if (input.contains("."))
            return input.substring(0, input.indexOf("."));
        else
            return input;
    }

    public String getAllUppercase(String input) {
        return input.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining());
    }

    public  String removefileExtention(String file) {
        int dotIndex = file.lastIndexOf('.');
        return (dotIndex == -1) ? file : file.substring(0, dotIndex);
    }

}
