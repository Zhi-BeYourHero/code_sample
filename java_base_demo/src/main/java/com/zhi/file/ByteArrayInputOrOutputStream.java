package com.zhi.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: luowenzhi
 * @CreateTime: 31/1/2022
 * @desc:
 */
public class ByteArrayInputOrOutputStream {
    private static String filePath = "java_base_demo/test.txt";
    public static void main(String[] args) throws IOException {
//        dataOutputStream();
//        outputWriter();
//        inputReader();
//        charArrayReader();
//        bufferedWriter();
        sysPrint();
    }

    public static void sysPrint() throws IOException{
        System.setOut(new PrintStream(filePath));
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }

    public static void bufferedWriter() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        for(int i = 0; i < 5; i++) {
            Student newStu = new Student("xiaozhi"+i, 10+i, 100d+i);
            bufferedWriter.write(newStu.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static void charArrayReader() throws IOException {
        InputStream in = new FileInputStream(filePath);
        Reader reader = new InputStreamReader(in);
        char[] chs = new char[1024];
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        int readNum = 0;
        while ((readNum = reader.read(chs)) != -1) {
            charArrayWriter.write(chs, 0, readNum);
        }
        System.out.println(charArrayWriter.toString());
        System.out.println(charArrayWriter.size());
    }

    public static void inputReader() throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        char[] buf = new char[1024];
        int readNum = inputStreamReader.read(buf);
        System.out.println(new String(buf, 0,readNum));
    }

    public static void outputWriter() throws IOException {
        OutputStream out = new FileOutputStream(filePath);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, StandardCharsets.UTF_8);;
        String str = "小智孝治";
        outputStreamWriter.write(str);
        outputStreamWriter.close();
    }

    public static void dataOutputStream() throws IOException {
        DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("java_base_demo/test.txt"));
        String data = Integer.toString(213);
        outputStream.write(data.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    public static void byteArray() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int byteRead = 0;
        byte[] buf = new byte[1024];
        while ((byteRead = fileInputStream.read(buf)) != -1) {
            output.write(buf, 0, byteRead);
        }
        System.out.println(output.toString());
        fileInputStream.close();
        output.close();
    }

}
