package com.marcossousadev.curso_spring_souzadev.database.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductEntity {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
