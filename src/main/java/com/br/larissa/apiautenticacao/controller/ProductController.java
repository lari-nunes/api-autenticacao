package com.br.larissa.apiautenticacao.controller;

import com.br.larissa.apiautenticacao.dto.ProductRequesDTO;
import com.br.larissa.apiautenticacao.dto.ProductResponseDTO;
import com.br.larissa.apiautenticacao.model.Product;
import com.br.larissa.apiautenticacao.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequesDTO body){
        Product newProduct = new Product(body);
        this.productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productList = this.productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
        return ResponseEntity.ok(productList);
    }
}
