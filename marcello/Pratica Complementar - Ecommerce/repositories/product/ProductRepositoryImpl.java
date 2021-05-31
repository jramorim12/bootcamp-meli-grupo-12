package br.com.marcello.ECommerce.repositories.product;

import br.com.marcello.ECommerce.dtos.ProductDto;
import br.com.marcello.ECommerce.entities.shop.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductDto> productList = new ArrayList<>();

    @Override
    public List<ProductDto> findByCategory(Category category) {
        return this.productList.stream()
                .filter(productDto -> productDto.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProducts() {
        return this.productList;
    }

    @Override
    public ProductDto editProduct(ProductDto product, ProductDto updatedProduct) {
        int index = this.productList.indexOf(product);
        this.productList.set(index, updatedProduct);

        return updatedProduct;
    }

    @Override
    public ProductDto deleteProduct(ProductDto productDto) {
        this.productList.remove(productDto);

        return productDto;
    }

    @Override
    public List<ProductDto> addProduct(List<ProductDto> productList) {

        this.productList.addAll(productList);

        return this.productList;
    }
}
