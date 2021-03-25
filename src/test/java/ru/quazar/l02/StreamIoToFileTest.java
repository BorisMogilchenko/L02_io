package ru.quazar.l05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class StreamIoToFileTest {

    String pathTest = "";
    String fileNameTest = "";
    String testOutputString = "";
    String testFileTargetString = "";

    @BeforeEach
    void setUp() {
        pathTest = "E:\\Backup\\";
        fileNameTest = "homework_02_output.txt";
        testOutputString = "jhgtlkjsenrltrdsdrrds;rkjhglksjnrd.lktnl";
    }

    @AfterEach
    void tearDown() {
        fileNameTest = "";
        pathTest = "";
    }

    @Test
    void uploadStreamToFileTest() {
        File outFile = new File(pathTest, fileNameTest);
        StreamIoToFile streamIoToFile = new StreamIoToFile();
        streamIoToFile.uploadStreamToFile(testOutputString, outFile);
        testFileTargetString = outFile.toString();

        Assertions.assertEquals(equals(testOutputString), equals(testFileTargetString));
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