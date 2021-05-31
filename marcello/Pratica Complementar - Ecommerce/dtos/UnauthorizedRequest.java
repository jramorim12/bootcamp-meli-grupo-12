package br.com.marcello.ECommerce.dtos;

public class UnauthorizedRequest {

    private String message;

    public UnauthorizedRequest() {
        String unauthorizedRequest = "You don't have permission to do this request!";
        this.message = unauthorizedRequest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
