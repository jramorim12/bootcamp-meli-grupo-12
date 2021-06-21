package com.example.demo.dtos;

public class PublicationInsertDTO {
    private String text;
    private long id;

    public PublicationInsertDTO(String text, long id) {
        this.text = text;
        this.id = id;
    }

    public PublicationInsertDTO() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
