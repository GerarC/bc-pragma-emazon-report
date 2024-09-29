package com.emazon.report.adapters.driven.mongo.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    private String id;
    private Long productId;
    private BigDecimal price;
    private Integer quantity;
}
