package ru.quazar.l02;

import lombok.Data;

import java.io.File;


/**
 * Put file "homework_02_input.txt" in any path of file system, then put into
 * application resource folder.
 * Make class for finding source file by path, find substring "Hello, guys!".
 * Write to the file "homework_02_output.txt" twenty symbols behind and
 * twenty symbols after finding substring.
 *
 * @version $Id: FileIoToStream.java,v 1.0 2021-01-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
public class HomeWork02 {

    private static final String inFileName = "homework_02_input.txt";
    private static final String outFileName = "homework_02_output.txt";

    public static void main(String[] args) throws Exception {
        String myStringToFile;
        String loadFilePath = "";

        FileIoGetter fileGetter = new FileIoGetter();

        switch (args.length) {
         case 1:
            loadFilePath = "";
            break;
         case 2:
            loadFilePath = args[1];
            break;
         default:
            throw new RuntimeException("No arguments!!!");
        }

        File inputFile = fileGetter.getFileWithConditions(args[0], loadFilePath, inFileName);
        FileIoToStream fileToStream = new FileIoToStream();
        myStringToFile = fileToStream.loadFileToStream(inputFile);
        File outFile = new File(inputFile.getParent(), outFileName);
        StreamIoToFile streamIoToFile = new StreamIoToFile();
        streamIoToFile.uploadStreamToFile(myStringToFile, outFile);
    }
}
