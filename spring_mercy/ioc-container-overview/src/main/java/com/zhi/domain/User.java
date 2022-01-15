package com.zhi.domain;

/**
 * @Author: luowenzhi
 * @CreateTime: 7/12/2021
 * @desc:
 */
public class User {
    private Long id;
    private String userName;

    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
