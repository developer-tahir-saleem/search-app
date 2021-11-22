package com.mikaelslab;


import com.mikaelslab.utils.FileFinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class UpperCaseTest {


    FileFinder files;
    UpperCase upperCase;

    @BeforeEach
    void setUp() {
        files = new FileFinder("./workdir");
        upperCase = new UpperCase();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test UpperCase ./workdir FBB upper-case")
    void upperCaseOne() {
        List<String> list = upperCase.find("FBB", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBar") ));
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBarBaz") ));
    }

    @Test
    @DisplayName("Test UpperCase ./workdir FB upper-case")
    void upperCaseTwo() {
        List<String> list = upperCase.find("FB", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBar") ));
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBarBaz") ));
    }

    @Test
    @DisplayName("Test UpperCase ./workdir BF upper-case")
    void upperCaseThree() {
        List<String> list = upperCase.find("BF", files);
        assertTrue(list.size()==0);
    }

}