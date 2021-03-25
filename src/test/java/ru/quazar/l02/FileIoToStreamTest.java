package ru.quazar.l05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class FileIoToStreamTest {

    String pathTest = "";
    String fileNameTest = "";
    String testOutputString = "";
    String actualSubString = "";
    String testSubString = "";

    String fileNameFromPathTest = "";
    String fileNameFromResourceTest = "";

    @BeforeEach
    void setUp() {
        pathTest = "E:\\Backup\\";
        fileNameTest = "homework_02_input.txt";
        testSubString = "Hello, guys!";
    }

    @AfterEach
    void tearDown() {
        fileNameTest = "";
        pathTest = "";

        fileNameFromPathTest = "";
        fileNameFromResourceTest = "";
        testOutputString = "";
    }

    @Test
    void loadFileToStreamTest() {
        String actualOutputString = "";
        String actualSubString = "";
        int iBeginFindString;

        File inputFile = new File(pathTest, fileNameTest);
        FileIoToStream fileToStream = new FileIoToStream();
        actualOutputString = fileToStream.loadFileToStream(inputFile);

        if (actualOutputString.contains(testSubString)) {
            if ((iBeginFindString = actualOutputString.indexOf(testSubString)) != 1 )
                actualSubString = actualOutputString.substring(iBeginFindString, testSubString.length());
        }

        Assertions.assertEquals(equals(testSubString), equals(actualSubString));
    }

    @Test
    void fileFromPathTest_NO_NULL() {
        File testFileFromPath = new File(fileNameFromPathTest);

        Assertions.assertNotNull(testFileFromPath);
    }

    @Test
    void fileFromResourceTest_NO_NULL() {
        File testFileFromResource = new File(fileNameFromResourceTest);

        Assertions.assertNotNull(testFileFromResource);
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