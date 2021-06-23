package com.exampleMongoDB.demo.service;

import com.exampleMongoDB.demo.dtos.AddressesDTO;
import com.exampleMongoDB.demo.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressesDTO> createAddresses(List<AddressesDTO> addresses){
        return addressRepository.saveAll(addresses);
    }


}
