package com.mikaelslab;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassBTest {

    public String passGeneralParam;
    public ClassB clB;

    @BeforeEach
    void setUp() {
        passGeneralParam = "abc";
        clB = new ClassB();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Class B Welcome method")
    void welcome() {
        assertAll("Check String of Class B",
                () -> assertEquals(passGeneralParam, clB.welcome(passGeneralParam))
        );
        assertTrue(true);
    }


}