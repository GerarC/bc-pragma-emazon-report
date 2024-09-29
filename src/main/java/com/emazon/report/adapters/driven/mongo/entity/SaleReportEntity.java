package com.emazon.report.adapters.driven.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("sales_report")
public class SaleReportEntity {
    @Id
    private String id;
    private String userId;
    private String userEmail;
    private LocalDateTime saleDate;
    private BigDecimal totalPrice;
    private Integer productCount;
    private List<ItemEntity> items;
}
