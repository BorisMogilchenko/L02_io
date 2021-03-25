package ru.quazar.l02;

import lombok.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Convert Output Stream into target file
 *
 * @version $Id: StreamIoToFile.java,v 1.0 2021-01-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
class StreamIoToFile {

    /**
     * Put file to target directory.
     *
     * @param myList Collection of strings for upload into file
     * @param target Upload file name
     * @throws IOException
     * @exception RuntimeException
     */

    void uploadStreamToFile (String outString, File target) {

        try(FileOutputStream outFile = new FileOutputStream(target)

        ){
            byte[]buffer = outString.getBytes();
            outFile.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
