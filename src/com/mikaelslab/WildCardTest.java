package com.mikaelslab;


import com.mikaelslab.utils.FileFinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class WildCardTest {

    FileFinder files;
    WildCardCase wildCardCase;

    @BeforeEach
    void setUp() {
        files = new FileFinder("./workdir");
        wildCardCase = new WildCardCase();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test WildCardCase ./workdir B*rBaz wild-card")
    void wildCardCaseOne() {
        List<String> list = wildCardCase.find("B*rBaz", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBarBaz") ));
    }



    @Test
    @DisplayName("Test WildCardCase ./workdir BrBaz wild-card")
    void wildCardCaseThree() {
        List<String> list = wildCardCase.find("BrBaz", files);
        assertTrue(list.size()==0);
    }

}