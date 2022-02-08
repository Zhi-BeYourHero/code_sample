package com.zhi.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: luowenzhi
 * @CreateTime: 31/1/2022
 * @desc:
 */
public class FileInputOrOutStream {
    public static void main(String[] args) throws IOException {
//        fileOutputStreamWrite();
//        System.out.println(System.getProperty("user.dir"));
//        fileInputStreamRead();
//        fileInputStreamAll();
        fileInputStreamBatch();
    }

    public static void fileInputStreamBatch() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("java_base_demo/test.txt")) {
            byte[] buf = new byte[1024];
            int off = 0;
            int byteRead = 0;
            while ((byteRead = fileInputStream.read(buf, off, 1024-off)) != -1) {
                off += byteRead;
                System.out.println(off);
            }
            String data = new String(buf, 0, off, StandardCharsets.UTF_8);
            System.out.println(data);
        }
    }

    public static void fileInputStreamAll() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("java_base_demo/test.txt")) {
            byte[] bytes = new byte[1024];
            int readByte;
            int readIndex = 0;
            while ((readByte = fileInputStream.read()) != -1) {
                bytes[readIndex++] = (byte) readByte;
            }
            String data = new String(bytes, 0, readIndex, StandardCharsets.UTF_8);
            System.out.println(data);
        }
    }

    public static void fileInputStreamRead() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("java_base_demo/test.txt")) {
            byte[] bytes = new byte[1024];
            int readIndex = fileInputStream.read(bytes);
            String data = new String(bytes, 0, readIndex, StandardCharsets.UTF_8);
            System.out.println(data);
        }
    }

    public static void fileOutputStreamWrite() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("java_base_demo/test.txt");) {
            String word = "zp，希望我能跟你走到最后，成为你想要的你";
            byte[] bytes = word.getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(bytes);
        }
    }
}
