package com.example.demo.controller;

import com.example.demo.dtos.PublicationDTO;
import com.example.demo.dtos.PublicationInsertDTO;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.PublicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublicationController {

    private final PublicationServiceImpl publicationService;

    public PublicationController(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping("/addPublication")
    public ResponseEntity<PublicationEntity> addPublication(@RequestBody PublicationInsertDTO publicationInsertDTO) {
        PublicationEntity newPublication = publicationService.addPublication(publicationInsertDTO);
        return new ResponseEntity<>(newPublication, HttpStatus.CREATED);
    }

    @GetMapping("/getPublication/{id}")
    public ResponseEntity getPublic(@PathVariable long id){
        return new ResponseEntity<PublicationDTO>(publicationService.getPublication(id), HttpStatus.OK);
    }

    @PutMapping("/updatePublication/{id}")
    public ResponseEntity getPublic(@RequestBody PublicationInsertDTO publicationInsertDTO ,@PathVariable long id){
        publicationService.updatePublication(publicationInsertDTO, id);
        return new ResponseEntity<String>("Publicação atualizada com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/deletePublication/{id}")
    public ResponseEntity deletePublic(@PathVariable long id){
        publicationService.deletePublication(id);
        return new ResponseEntity<String>("Publicação deletada com sucesso!!", HttpStatus.OK);
    }



}
