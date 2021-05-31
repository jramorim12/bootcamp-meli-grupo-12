package br.com.marcello.LinkTracer.controllers;

import br.com.marcello.LinkTracer.dto.LinkDTO;
import br.com.marcello.LinkTracer.entities.Link;
import br.com.marcello.LinkTracer.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkTracerController {

    @Autowired
    private LinkRepository linkRepositoryImpl;

    @PostMapping("/createLink")
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkDTO linkDTO) {

        this.linkRepositoryImpl.addLink(linkDTO);

        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }

    @GetMapping
    public RedirectView redirectToLink(@RequestParam(value = "id") String id) {
        RedirectView redirect = new RedirectView();

        Long longId = Long.parseLong(id);
        LinkDTO linkDTO = this.linkRepositoryImpl.findById(longId);
        if(linkDTO == null)
            return new RedirectView("http://localhost:8080/notFound");
        redirect.setUrl(linkDTO.getUrl());
        this.linkRepositoryImpl.incrementAccessCount(linkDTO);

        return redirect;
    }

    @GetMapping("/metrics")
    public String getMetrics(@RequestParam(value = "id") String id) {

        Long longId = Long.parseLong(id);
        LinkDTO linkDTO = this.linkRepositoryImpl.findById(longId);

        if(linkDTO == null)
            return "Link not found!";

        Integer accessCount = linkDTO.getAccessCount();

        return "The following link was accessed " + accessCount + " times.";
    }

    @DeleteMapping("/deleteLink")
    public ResponseEntity<LinkDTO> deleteLink(@RequestParam(value = "id") String id) {

        Long longId = Long.parseLong(id);
        LinkDTO linkDTORemoved = this.linkRepositoryImpl.deleteLink(longId);

        if(linkDTORemoved == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(linkDTORemoved, HttpStatus.OK);
    }

}
