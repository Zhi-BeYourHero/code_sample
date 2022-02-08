package com.zhi.file;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: luowenzhi
 * @CreateTime: 2/2/2022
 * @desc: BasicDB的使用
 */
public class BasicDBApplication {
    private static final String FILE_PATH = "java_base_demo";

    public static void main(String[] args) {

    }

    public static byte[] toBytes(Student student) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(student.getName());
        dataOutputStream.writeInt(student.getAge());
        dataOutputStream.writeDouble(student.getScore());
        return outputStream.toByteArray();
    }

    public static void saveStudents(Map<String, Student> studentMa) throws IOException {
        BasicDB db = new BasicDB(FILE_PATH, "student");
        for (Map.Entry<String, Student> studentEntry : studentMa.entrySet()) {
            db.put(studentEntry.getKey(), toBytes(studentEntry.getValue()));
        }
        db.close();
    }
}
