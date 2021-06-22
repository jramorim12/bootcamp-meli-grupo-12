package com.example.demo.dtos;

public class UserNewPasswordDTO {
    long id;
    String password;

    public UserNewPasswordDTO(long id, String password) {
        this.id = id;
        this.password = password;
    }

    public UserNewPasswordDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
