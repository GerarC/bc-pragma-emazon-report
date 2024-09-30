package com.emazon.report.adapters.driving.rest.v1.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.emazon.report.adapters.driving.rest.v1.dto.request.SaleReportRequest;
import com.emazon.report.adapters.driving.rest.v1.dto.response.SaleReportResponse;
import com.emazon.report.adapters.driving.rest.v1.mapper.request.SalesReportRequestMapper;
import com.emazon.report.adapters.driving.rest.v1.mapper.response.SalesReportResponseMapper;
import com.emazon.report.domain.api.SalesReportServicePort;
import com.emazon.report.domain.model.SaleReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

class SalesReportServiceImplTest {

    @Mock
    private SalesReportServicePort salesReportServicePort;

    @Mock
    private SalesReportRequestMapper salesReportRequestMapper;

    @Mock
    private SalesReportResponseMapper salesReportResponseMapper;

    @InjectMocks
    private SalesReportServiceImpl salesReportService;

    private SaleReportRequest saleReportRequest;
    private SaleReport saleReport;
    private SaleReportResponse saleReportResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a SaleReportRequest instance for testing
        saleReportRequest = new SaleReportRequest(
                LocalDateTime.now(),
                BigDecimal.valueOf(100.00),
                2,
                Collections.emptyList() // Assuming no items for simplicity
        );

        // Create a SaleReport instance for testing
        saleReport = new SaleReport(
                "reportId",
                "userId",
                "user@example.com",
                saleReportRequest.getSaleDate(),
                saleReportRequest.getTotalPrice(),
                saleReportRequest.getProductCount(),
                Collections.emptyList() // Assuming no items for simplicity
        );

        // Create a SaleReportResponse instance for testing
        saleReportResponse = new SaleReportResponse(
                saleReport.getId(),
                saleReport.getUserId(),
                saleReport.getUserEmail(),
                saleReport.getSaleDate(),
                saleReport.getTotalPrice(),
                saleReport.getProductCount()
        );
    }

    @Test
    void save_ShouldReturnSaleReportResponse_WhenSuccessful() {
        when(salesReportRequestMapper.toDomain(saleReportRequest)).thenReturn(saleReport);
        when(salesReportServicePort.save(saleReport)).thenReturn(saleReport);
        when(salesReportResponseMapper.toResponse(saleReport)).thenReturn(saleReportResponse);

        SaleReportResponse result = salesReportService.save(saleReportRequest);

        assertNotNull(result);
        assertEquals(saleReportResponse.getId(), result.getId());
        assertEquals(saleReportResponse.getUserId(), result.getUserId());
        assertEquals(saleReportResponse.getTotalPrice(), result.getTotalPrice());
        assertEquals(saleReportResponse.getProductCount(), result.getProductCount());

        verify(salesReportRequestMapper).toDomain(saleReportRequest);
        verify(salesReportServicePort).save(saleReport);
        verify(salesReportResponseMapper).toResponse(saleReport);
    }
}