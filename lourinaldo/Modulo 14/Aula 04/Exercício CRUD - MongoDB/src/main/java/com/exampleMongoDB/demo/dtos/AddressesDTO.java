package com.exampleMongoDB.demo.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adresses")
public class AddressesDTO {

    @Id
    private String id;
//    @Indexed(direction = IndexDirection.ASCENDING, unique = true)
   private String street;

//   @Transient
   private String zipcode;

    public AddressesDTO() {}

    public AddressesDTO(String id, String street, String zipcode) {
        this.id = id;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
