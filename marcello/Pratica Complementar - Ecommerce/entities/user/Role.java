package br.com.marcello.ECommerce.entities.user;

public enum Role {

    ADMIN("Admin"),
    CUSTOMER("Customer");

    private String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User Role: " + this.role;
    }
}
