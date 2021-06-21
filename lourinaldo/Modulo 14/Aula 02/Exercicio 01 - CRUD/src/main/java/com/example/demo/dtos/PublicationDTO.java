package com.example.demo.dtos;

public class PublicationDTO {
    private String text;
    private long idUser;

    public PublicationDTO(String text, long idUser) {
        this.text = text;
        this.idUser = idUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}
