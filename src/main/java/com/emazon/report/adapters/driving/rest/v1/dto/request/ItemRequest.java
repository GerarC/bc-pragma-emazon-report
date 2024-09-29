package com.emazon.report.adapters.driving.rest.v1.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private Long productId;
    private BigDecimal price;
    private Integer quantity;
}
