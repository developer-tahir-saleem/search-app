package com.mikaelslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
       ClassA calA = new ClassA();
       ClassB calB = new ClassB();
        System.out.println("End Class A : " +calA.welcome("One"));
        System.out.println("End Class B : " +calB.welcome("Two"));
	// write your code here
        try {
            Files.walk(Paths.get("./"))
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }catch (IOException ioe){
            System.out.println("dd"+ ioe.getMessage());
        }

    }
}
