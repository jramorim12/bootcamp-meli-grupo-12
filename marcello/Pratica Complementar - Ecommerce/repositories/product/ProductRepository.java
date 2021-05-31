package br.com.marcello.ECommerce.repositories.product;

import br.com.marcello.ECommerce.dtos.ProductDto;
import br.com.marcello.ECommerce.entities.shop.Category;

import java.util.List;

public interface ProductRepository {

    List<ProductDto> addProduct(List<ProductDto> productList);

    ProductDto deleteProduct(ProductDto productDto);

    ProductDto editProduct(ProductDto product, ProductDto updatedProduct);

    List<ProductDto> getProducts();

    List<ProductDto> findByCategory(Category category);

}
