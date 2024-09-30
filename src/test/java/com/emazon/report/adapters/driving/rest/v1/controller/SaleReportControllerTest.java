package com.emazon.report.adapters.driving.rest.v1.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.emazon.report.adapters.driving.rest.v1.dto.request.SaleReportRequest;
import com.emazon.report.adapters.driving.rest.v1.dto.response.SaleReportResponse;
import com.emazon.report.adapters.driving.rest.v1.service.SalesReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@WebMvcTest(SaleReportController.class)
@AutoConfigureMockMvc(addFilters = false)
class SaleReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesReportService salesReportService;

    @TestConfiguration
    static class TestMongoConfig {
        @Bean
        public MongoTemplate mongoTemplate() {
            return new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/test"));
        }
    }

    private SaleReportRequest saleReportRequest;
    private SaleReportResponse saleReportResponse;

    @BeforeEach
    void setUp() {
        saleReportRequest = new SaleReportRequest(
                LocalDateTime.now(),
                BigDecimal.valueOf(100.00),
                2,
                Collections.emptyList()
        );

        saleReportResponse = new SaleReportResponse(
                "reportId",
                "userId",
                "user@example.com",
                saleReportRequest.getSaleDate(),
                saleReportRequest.getTotalPrice(),
                saleReportRequest.getProductCount()
        );
    }

    @Test
    void save_ShouldReturnCreated_WhenSuccessful() throws Exception {
        when(salesReportService.save(any(SaleReportRequest.class))).thenReturn(saleReportResponse);

        mockMvc.perform(post("/v1/sale-reports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"saleDate\":\"" + saleReportRequest.getSaleDate() + "\"," +
                                "\"totalPrice\":" + saleReportRequest.getTotalPrice() + "," +
                                "\"productCount\":" + saleReportRequest.getProductCount() + "," +
                                "\"items\":[]}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(saleReportResponse.getId()))
                .andExpect(jsonPath("$.userId").value(saleReportResponse.getUserId()))
                .andExpect(jsonPath("$.totalPrice").value(saleReportResponse.getTotalPrice().doubleValue()))
                .andExpect(jsonPath("$.productCount").value(saleReportResponse.getProductCount()));
    }

    @Test
    void save_ShouldReturnBadRequest_WhenValidationFails() throws Exception {
        String invalidJson = "{}";

        mockMvc.perform(post("/v1/sale-reports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}