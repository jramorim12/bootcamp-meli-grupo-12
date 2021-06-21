package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "User")
public class UserEntity {

    public enum UserType {
        SELLER,
        BUYER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private UserType type;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    List<PublicationEntity> publicationEntities;
}
