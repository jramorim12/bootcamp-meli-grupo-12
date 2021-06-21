package com.example.demo.service;


import com.example.demo.dtos.PublicationDTO;
import com.example.demo.dtos.PublicationInsertDTO;
import com.example.demo.entity.PublicationEntity;

public interface PublicationService {

    public PublicationEntity addPublication(PublicationInsertDTO publicationEntity);
    public PublicationDTO getPublication(long id);
    public void updatePublication(PublicationInsertDTO publicationEntity, long id);
    public void deletePublication(long id);
}
