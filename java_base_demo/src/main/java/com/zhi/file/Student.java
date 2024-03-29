package com.zhi.file;

import java.io.Serializable;

/**
 * @Author: luowenzhi
 * @CreateTime: 1/2/2022
 * @desc:
 */
public class Student implements Serializable {
    private String name;
    private Integer age;
    private Double score;

    public Student(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score='" + score + '\'' +
                '}';
    }
}
