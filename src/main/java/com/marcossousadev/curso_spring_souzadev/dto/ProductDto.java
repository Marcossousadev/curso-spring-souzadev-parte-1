package com.marcossousadev.curso_spring_souzadev.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDto {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
