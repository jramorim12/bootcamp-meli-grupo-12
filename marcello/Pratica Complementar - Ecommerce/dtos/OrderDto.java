package br.com.marcello.ECommerce.dtos;

import java.util.List;

public class OrderDto {

    private List<ProductDto> productsList;

    public List<ProductDto> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductDto> productsList) {
        this.productsList = productsList;
    }

}
