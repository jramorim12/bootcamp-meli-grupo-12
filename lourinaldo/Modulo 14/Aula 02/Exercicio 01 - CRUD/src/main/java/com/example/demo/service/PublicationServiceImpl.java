package com.example.demo.service;

import com.example.demo.dtos.PublicationDTO;
import com.example.demo.dtos.PublicationInsertDTO;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.repository.UserRepository;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
public class PublicationServiceImpl implements PublicationService{

    private final PublicationRepository publicationRepository;
    private final UserRepository userRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository, UserRepository userRepository) {
        this.publicationRepository = publicationRepository;
        this.userRepository =  userRepository;
    }

    private PublicationEntity insertionDtoToEntity(PublicationInsertDTO publication){
        UserEntity user = userRepository.getById(publication.getId());
        PublicationEntity publicationEntity = new PublicationEntity();

        publicationEntity.setText(publication.getText());
        publicationEntity.setUserEntity(user);

        return publicationEntity;

    }

    private PublicationEntity updateEntityValue(PublicationEntity publication, PublicationInsertDTO publicationInsertDTO){
        UserEntity user = userRepository.getById(publicationInsertDTO.getId());
        publication.setText(publicationInsertDTO.getText());
        publication.setUserEntity(user);
        return publication;
    }

    @Override
    public PublicationEntity addPublication(PublicationInsertDTO publicationEntity) {

        return publicationRepository.save(this.insertionDtoToEntity(publicationEntity));
    }

    @Override
    public PublicationDTO getPublication(long id) {
        PublicationEntity publicationEntity = publicationRepository.getById(id);
        return new PublicationDTO(publicationEntity.getText(), publicationEntity.getId());
    }

    @Override
    public void updatePublication(PublicationInsertDTO publicationEntity, long id) {
        PublicationEntity publicationOld = publicationRepository.getById(id);
        publicationRepository.save(this.updateEntityValue(publicationOld, publicationEntity));
    }

    @Override
    public void deletePublication(long id) {
        publicationRepository.getById(id);
    }


}
