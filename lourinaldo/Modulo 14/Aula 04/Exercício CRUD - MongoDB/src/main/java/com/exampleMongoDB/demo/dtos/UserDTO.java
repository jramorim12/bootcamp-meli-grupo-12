package com.exampleMongoDB.demo.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "users")
public class UserDTO {

    @Id
    private String id;

    private String login;

    private String password;

    @DBRef
    @Field(name = "adresses")
    private List<AddressesDTO> adresses;

    public UserDTO() {}

    public UserDTO(String id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public List<AddressesDTO> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<AddressesDTO> adresses) {
        this.adresses = adresses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
