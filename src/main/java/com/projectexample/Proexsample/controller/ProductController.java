package com.projectexample.Proexsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectexample.Proexsample.dto.ProductDTO;
import com.projectexample.Proexsample.dto.UserDTO;
import com.projectexample.Proexsample.entity.Product;
import com.projectexample.Proexsample.entity.User;
import com.projectexample.Proexsample.repository.ProductRepo;
import com.projectexample.Proexsample.repository.UserRepo;
import com.projectexample.Proexsample.util.StanderdResponse;

@RestController
@CrossOrigin
@RequestMapping("api/v1/product")
public class ProductController {
    
    @Autowired
    private ProductRepo productRepo;

    @PostMapping
    public ResponseEntity<StanderdResponse> addNewProduct(@RequestBody ProductDTO productDto){
        try {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setdescription(productDto.getDescription());
            product.setcategory(productDto.getCategory());
            product.setbrand(productDto.getBrand());
            product.setsupplier(productDto.getSupplier());
            product.setcolor(productDto.getColor());

            productRepo.save(product);
            return ResponseEntity.ok(new StanderdResponse(0, "", "Operation Successfuly", true));

        } catch (Exception e) {
            return ResponseEntity.ok(new StanderdResponse(1, "", "something went wrong", false));
        }

    }
}
