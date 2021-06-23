package com.exampleMongoDB.demo.repository;

import com.exampleMongoDB.demo.dtos.AddressesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<AddressesDTO, String> {

}
