package ru.quazar.l05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeWork02Test {

    String inFileName = "";
    String outFileName = "";

    @BeforeEach
    void setUp() {
        inFileName = "homework_02_input.txt";
        outFileName = "homework_02_output.txt";

    }

    @AfterEach
    void tearDown() {
        inFileName = "";
        outFileName = "";
    }

    @Test
    public static void main(String[] args) {
        int loadTarget;

        switch (args.length) {
            case 1:
                loadTarget = 2;
                System.out.println("Testing load from resource file ...");
                Assertions.assertEquals(loadTarget, Integer.parseInt (args[0].trim ()));
                break;
            case 2:
                loadTarget = 1;
                System.out.println("Testing load from path file ...");
                Assertions.assertEquals(loadTarget, Integer.parseInt (args[0].trim ()));
                break;
            default:
                loadTarget = 0;
                Assertions.assertEquals(loadTarget, args.length);
        }

    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}