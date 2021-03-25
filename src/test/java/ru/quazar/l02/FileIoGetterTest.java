package ru.quazar.l05;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;

class FileIoGetterTest {

    String pathTest = "";
    String fileNameTest = "";
    String testOutputString = "";
    String testFileTargetString = "";
    FileIoGetter fileIoGetter;

    @BeforeEach
    void setUp() {
        pathTest = "E:\\Backup\\";
        fileNameTest = "homework_02_input.txt";
        fileIoGetter = new FileIoGetter();
    }

    @AfterEach
    void tearDown() {
        fileNameTest = "";
        pathTest = "";
    }

    @Test
    void getFileWithConditions() {

    }

    @SneakyThrows
    @Test
    void getFileWithPathTest() {
        File inFileTest = new File(pathTest, fileNameTest);
        File inFileActual;

        Method method = fileIoGetter.getClass().getDeclaredMethod("getFileByPath");
        method.setAccessible(true);
        inFileActual = (File) method.invoke(fileIoGetter);

        Assertions.assertEquals(inFileTest, inFileActual);
    }

    @SneakyThrows
    @Test
    void getFileWithResourceTest() {
        File inFileTest = new File("", fileNameTest);
        File inFileActual;

        Method method = fileIoGetter.getClass().getDeclaredMethod("getFileFromResources");
        method.setAccessible(true);
        inFileActual = (File) method.invoke(fileIoGetter);

        Assertions.assertEquals(inFileTest, inFileActual);
    }

}