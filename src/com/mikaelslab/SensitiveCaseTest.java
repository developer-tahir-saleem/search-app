package com.mikaelslab;


import com.mikaelslab.utils.FileFinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SensitiveCaseTest {
    
    
//    ./workdir fbb sensitive-case



    FileFinder files;
    SensitiveCase sensitiveCase;

    @BeforeEach
    void setUp() {
        files = new FileFinder("./workdir");
        sensitiveCase = new SensitiveCase();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test SensitiveCase ./workdir fbb sensitive-case")
    void sensitiveCaseOne() {
        List<String> list = sensitiveCase.find("fbb", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBar") ));
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBarBaz") ));
    }

    @Test
    @DisplayName("Test SensitiveCase ./workdir fb sensitive-case")
    void sensitiveCaseTwo() {
        List<String> list = sensitiveCase.find("fb", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBar") ));
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBarBaz") ));
    }

    @Test
    @DisplayName("Test SensitiveCase ./workdir fBb sensitive-case")
    void sensitiveCaseThree() {
        List<String> list = sensitiveCase.find("fBb", files);
        assertTrue(list.size()==0);
    }

}