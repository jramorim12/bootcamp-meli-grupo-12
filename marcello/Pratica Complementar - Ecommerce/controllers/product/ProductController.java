package br.com.marcello.ECommerce.controllers.product;

import br.com.marcello.ECommerce.dtos.*;
import br.com.marcello.ECommerce.entities.user.Role;
import br.com.marcello.ECommerce.entities.user.User;
import br.com.marcello.ECommerce.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepositoryImpl;

    @PostMapping("/getByCategory")
    public ResponseEntity<?> getByCategory(@RequestBody CategoryRequest categoryRequest) {

        if(!this.isAdmin(categoryRequest.getUser()))
            return new ResponseEntity<>(new UnauthorizedRequest(), HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(this.productRepositoryImpl.findByCategory(categoryRequest.getCategory()), HttpStatus.OK);

    }

    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts(@RequestBody GetRequest getRequest) {

        if(!this.isAdmin(getRequest.getUser()))
            return new ResponseEntity<>(new UnauthorizedRequest(), HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(this.productRepositoryImpl.getProducts(), HttpStatus.OK);

    }

    @PostMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody UpdateRequest updateRequest) {

        if(!this.isAdmin(updateRequest.getUser()))
            return new ResponseEntity<>(new UnauthorizedRequest(), HttpStatus.UNAUTHORIZED);

        this.productRepositoryImpl.editProduct(updateRequest.getProduct(), updateRequest.getUpdatedProduct());

        return new ResponseEntity<>(updateRequest.getUpdatedProduct(), HttpStatus.OK);

    }


    @PostMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestBody DeleteRequest deleteRequest) {

        if(!this.isAdmin(deleteRequest.getUser()))
            return new ResponseEntity<>(new UnauthorizedRequest(), HttpStatus.UNAUTHORIZED);

        this.productRepositoryImpl.deleteProduct(deleteRequest.getProduct());

        return new ResponseEntity<>(deleteRequest.getProduct(), HttpStatus.OK);

    }

    @PostMapping("/registerProduct")
    public ResponseEntity<?> registerProducts(@RequestBody AdminRequest adminRequest) {

        if(!this.isAdmin(adminRequest.getUser()))
            return new ResponseEntity<>(new UnauthorizedRequest(), HttpStatus.UNAUTHORIZED);

        this.productRepositoryImpl.addProduct(adminRequest.getProductsList());

        return new ResponseEntity<>(adminRequest.getProductsList(), HttpStatus.OK);
    }

    private Boolean isAdmin(User user) {
        return user.getRole().equals(Role.ADMIN);
    }

}
