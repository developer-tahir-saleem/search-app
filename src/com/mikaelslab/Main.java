package com.mikaelslab;

import com.mikaelslab.utils.Request;

public class Main {

    public static void main(String[] args) {
       Request req = new Request(args);

        if (req.isValidParam() && req.isValidPath() && req.isValidKeyword() && req.isValidPattern()) {
            System.out.println("Program Is working ");
        }

//       ClassA cal = new ClassA();
//       ClassB calB = new ClassB();
//        System.out.println("End Class A : " +calA.welcome("One"));
//        System.out.println("End Class B : " +calB.welcome("Two"));
//	// write your code here
//        try {
//            Files.find(Paths.get("../../"),
//                            Integer.MAX_VALUE,
//                            (filePath, fileAttr) -> fileAttr.isRegularFile())
//                    .forEach(System.out::println);
//        }catch (IOException ioe){
//            System.out.println("dd"+ ioe.getMessage());
//        }

    }
}
