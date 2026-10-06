package com.marcossousadev.curso_spring_souzadev.controller;

import com.marcossousadev.curso_spring_souzadev.database.model.ProductEntity;
import com.marcossousadev.curso_spring_souzadev.dto.ProductDto;
import com.marcossousadev.curso_spring_souzadev.exception.NotFoundException;
import com.marcossousadev.curso_spring_souzadev.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProductController {
    // quando temos vários private final de services, usamos o private final com RequiredArgsConstructor
    private final ProductService service;
    // para que a injeção de dependências no Spring funcione, é preciso que essa classe que você
    // tá tentando injetar, essa classe precisar ser um Bean gerenciado pelo Spring
    // por isso usamos a anotação @Service, que fala para o Spring que nossa classe é um Bean
    // podemos injetar

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductDto product) {
        return service.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable("id") Integer id,
                                                       @RequestBody ProductDto body) throws NotFoundException {
        ProductEntity produto =  service.updateProduct(id, body);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id){
        service.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    // exemplo se queremos que o Spring retorne outro tipo de dado
    // diferente de um JSON
    /* @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllExemplo(){
        return service.findAll();
    } */


}
