package ru.quazar.l02;

import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Convert source file into Input Stream
 *
 * @version $Id: FileIoToStream.java,v 1.0 2021-01-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
class FileIoToStream {
    private static final String findString = "Hello, guys!";

    /**
     * Get file from source.
     *
     * @param inputFile Object File with path to file
     *
     * @return String file path
     *
     * @throws IOException
     * @exception RuntimeException
     */

    String loadFileToStream(File inputFile) {

        String myStringToFile = "";
        try (FileInputStream inFile = new FileInputStream(inputFile)

        ) {
            myStringToFile = fileFromStreamToString(inFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return myStringToFile;
    }

    /**
     * Get file from stream to string.
     *
     * @param inFile FileInputStream stream
     *
     * @return cTargetString String for write to file
     *
     * @throws IOException
     * @exception RuntimeException
     */
    private String fileFromStreamToString(FileInputStream inFile) throws IOException {
        String cTargetString = "";
        int c;
        String sInputFile;

        StringBuilder inCharToString = new StringBuilder();
        while ((c = inFile.read()) != -1) {
            inCharToString.append(Character.toChars(c));
        }
        cTargetString = findSubstring(inCharToString.toString());

        return cTargetString;
    }

    /**
     * Find target substring from source string.
     *
     * @param cSourceString Source string
     *
     * @return cFindString Finding Substring
     *
     */
    private String findSubstring(String cSourceString) {
        String cOutSubString1 = "";
        String cOutSubString2 = "";
        String cFindString = "";
        int iBeginFindString;
        int iLenSubString = 20;

        if (cSourceString.contains(findString)) {
            if ((iBeginFindString = cSourceString.indexOf(findString)) != -1) {
                cOutSubString1 = cSourceString.substring(iBeginFindString - iLenSubString, iBeginFindString);
                cOutSubString2 = cSourceString.substring(iBeginFindString + findString.length(), iBeginFindString + (findString.length()) + (iLenSubString));
            }
        }

        cFindString = cOutSubString1 + cOutSubString2;

        return cFindString;
    }
}
