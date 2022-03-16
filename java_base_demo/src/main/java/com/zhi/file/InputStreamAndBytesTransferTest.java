package com.zhi.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: luowenzhi
 * @CreateTime: 15/3/2022
 * @desc:
 */
public class InputStreamAndBytesTransferTest {
    public static void main(String[] args) throws Exception {
        testWriteByInputStream();
    }

    private static void testWriteByBytes() throws Exception{
        File file = new File("/Users/luowenzhi_1/Downloads/ideaIU-2021.1.2.dmg");
        byte[] bytes = FileUtils.readFileToByteArray(file);
        FileUtils.writeByteArrayToFile(new File("/Users/luowenzhi_1/Desktop/bytes.dmg"), bytes);
        Thread.sleep(100000000);
    }

    private static void testWriteByInputStream() throws IOException, InterruptedException {
        File file = new File("/Users/luowenzhi_1/Downloads/ideaIU-2021.1.2.dmg");
        FileInputStream inputStream = new FileInputStream(file);
        FileUtils.copyInputStreamToFile(inputStream, new File("/Users/luowenzhi_1/Desktop/streams.dmg"));
        Thread.sleep(100000000);
    }
}
