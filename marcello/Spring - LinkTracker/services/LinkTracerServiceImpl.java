package br.com.marcello.LinkTracer.services;

import org.springframework.stereotype.Component;

@Component
public class LinkTracerServiceImpl implements LinkTracerService {

    @Override
    public Long generateId() {
        return this.generateRandomLongWithBounds();
    }

    private Long generateRandomLongWithBounds() {
        Long rightLimit = 50L;
        Long leftLimit = 1L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

}
