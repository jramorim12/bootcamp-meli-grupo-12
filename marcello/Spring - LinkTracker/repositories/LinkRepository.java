package br.com.marcello.LinkTracer.repositories;

import br.com.marcello.LinkTracer.dto.LinkDTO;

public interface LinkRepository {

    LinkDTO findById(Long id);

    LinkDTO addLink(LinkDTO linkDTO);

    LinkDTO deleteLink(Long id);

    void incrementAccessCount(LinkDTO linkDTO);

}
