package com.emazon.report.adapters.driving.rest.v1.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleReportRequest {
    @NotNull
    private LocalDateTime saleDate;
    @NotNull
    private BigDecimal totalPrice;
    @NotNull
    private Integer productCount;
    @NotNull
    private List<ItemRequest> items;
}
