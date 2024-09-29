package com.emazon.report.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SaleReport {
    private String id;
    private String userId;
    private String userEmail;
    private LocalDateTime saleDate;
    private BigDecimal totalPrice;
    private Integer productCount;
    private List<Item> items;

    public SaleReport(String id,
                      String userId,
                      String userEmail,
                      LocalDateTime saleDate,
                      BigDecimal totalPrice,
                      Integer productCount,
                      List<Item> items) {
        this.id = id;
        this.userId = userId;
        this.userEmail = userEmail;
        this.saleDate = saleDate;
        this.totalPrice = totalPrice;
        this.productCount = productCount;
        this.items = items;
    }

    public SaleReport() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
