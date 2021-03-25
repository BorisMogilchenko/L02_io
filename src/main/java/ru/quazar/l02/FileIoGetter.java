package ru.quazar.l02;

import com.google.common.annotations.VisibleForTesting;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Get source file
 *
 * @version $Id: FileIoGetter.java,v 1.0 2021-01-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
class FileIoGetter {

    /**
     * Get file with input conditions.
     *
     * @param fileName Source file name
     * @param filePath Source file path
     * @throws IOException
     * @exception RuntimeException
     */
    File getFileWithConditions(String target, String filePath, String fileName) throws IOException {
        switch (target) {
            case "1":
                return getFileByPath(filePath, fileName);
            case "2":
                return getFileFromResources(fileName);
            default:
                throw new RuntimeException("Not correct first argument");
        }
    }

    /**
     * Get source file from path
     *
     * @return File by path.
     */

    @VisibleForTesting
    private  File getFileByPath(String filePath, String fileName) {
        return new File(filePath, fileName);
    }

    /**
     * Get source file from resources
     *
     * @return File from resources.
     */

    @VisibleForTesting
    private File getFileFromResources(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IOException("file is not found!");
        } else {
//            System.out.println("Ресурсный файл: " + new File(resource.getFile()).toString());
//            System.out.println("");
            return new File(resource.getFile());
        }
    }
}
