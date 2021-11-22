package com.mikaelslab;


import com.mikaelslab.utils.FileFinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class CamelCaseTest {

    FileFinder files;
    CamelCase camelCase;

    @BeforeEach
    void setUp() {
        files = new FileFinder("./workdir");
        camelCase = new CamelCase();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test CamelCase ./workdir FooBarzoo camel-case")
    void camelCaseOne() {
        List<String> list = camelCase.find("FooBarzoo", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBar") ));
    }

    @Test
    @DisplayName("Test CamelCase ./workdir FBar camel-case")
    void camelCaseTwo() {
        List<String> list = camelCase.find("FBar", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBar") ));
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBarBaz") ));
    }

    @Test
    @DisplayName("Test CamelCase ./workdir FoBa camel-case")
    void camelCaseThree() {
        List<String> list = camelCase.find("FoBa", files);
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBar") ));
        assertTrue(list.stream().anyMatch(x ->  x.contains("FooBarBaz") ));
    }

}