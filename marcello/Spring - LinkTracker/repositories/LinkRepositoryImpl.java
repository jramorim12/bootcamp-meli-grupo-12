package br.com.marcello.LinkTracer.repositories;

import br.com.marcello.LinkTracer.dto.LinkDTO;
import br.com.marcello.LinkTracer.services.LinkTracerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    private List<LinkDTO> linkDtoList = new ArrayList<>();

    @Autowired
    private LinkTracerService linkTracerServiceImpl;

    @Override
    public void incrementAccessCount(LinkDTO linkDTO) {
        Integer accessCount = linkDTO.getAccessCount();
        accessCount++;
        linkDTO.setAccessCount(accessCount);
    }

    @Override
    public LinkDTO deleteLink(Long id) {
        LinkDTO linkDTO = this.findById(id);
        if(linkDTO == null) {
            return null;
        }
        this.linkDtoList.remove(linkDTO);

        return linkDTO;
    }

    @Override
    public LinkDTO addLink(LinkDTO linkDTO) {
        Long id = null;
        do {
            id = this.linkTracerServiceImpl.generateId();
        } while(this.findById(id) != null);
        linkDTO.setLinkId(id);
        this.linkDtoList.add(linkDTO);

        return linkDTO;
    }

    @Override
    public LinkDTO findById(Long id) {
        return this.linkDtoList.stream()
                .filter(linkDTO -> linkDTO.getLinkId().equals(id))
                .findFirst()
                .orElse(null);

    }


}
