package com.marcossousadev.curso_spring_souzadev.service;

import com.marcossousadev.curso_spring_souzadev.database.model.ProductEntity;
import com.marcossousadev.curso_spring_souzadev.dto.ProductDto;
import com.marcossousadev.curso_spring_souzadev.exception.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// todas essas anotações que colocamos nas nossas classes
// são Beans, classes gerenciadas pelo próprio Spring
@Service
public class ProductService {
    private static final List<ProductEntity> PRODUTOS = new ArrayList<>();
    // bloco de inicialização estático
    // chamado quando nossa classe for carregada
    // aqui no caso, quando ela for carregada cria-se esse produtos mockados de exemplo
    static {
      PRODUTOS.add(ProductEntity.builder().
              id(1)
              .name("Notebook")
              .price(new BigDecimal(2500))
              .quantity(20).build());

               PRODUTOS.add( ProductEntity.builder().
                       id(1)
                       .name("Celular")
                       .price(new BigDecimal(1500))
                       .quantity(10).build());

               PRODUTOS.add(ProductEntity.builder().
                       id(1)
                       .name("Tv")
                       .price(new BigDecimal(3500))
                       .quantity(40).build());
    }

    public List<ProductEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }
    public ProductEntity createProduct(ProductDto produto){
        Integer indentificador = PRODUTOS.stream().mapToInt(ProductEntity::getId).max().orElse(0) + 1;

        ProductEntity newProduct = ProductEntity.builder()
                .name(produto.getName())
                .price(produto.getPrice())
                .quantity(produto.getQuantity())
                .id(indentificador)
                .build();

        PRODUTOS.add(newProduct);
        return newProduct;
    }
    public ProductEntity updateProduct(Integer id, ProductDto produtoDto) throws NotFoundException {

        ProductEntity produto = PRODUTOS.stream().filter(p -> p.getId().equals(id)).findAny().orElseThrow(() ->
                new NotFoundException("Produto não encontrado!"));

        produto.setName(produtoDto.getName());
        produto.setPrice(produtoDto.getPrice());
        produto.setQuantity(produtoDto.getQuantity());

        return produto;
    }
    public void deleteProductById(Integer id) {
        PRODUTOS.removeIf(produto -> produto.getId().equals(id));
    }
}
