package com.emazon.report.adapters.driving.rest.v1.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleReportResponse {
    private String id;
    private String userId;
    private String userEmail;
    private LocalDateTime saleDate;
    private BigDecimal totalPrice;
    private Integer productCount;
}
