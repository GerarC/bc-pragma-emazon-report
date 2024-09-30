package com.emazon.report.adapters.driven.mongo.adapter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.emazon.report.adapters.driven.mongo.entity.SaleReportEntity;
import com.emazon.report.adapters.driven.mongo.mapper.SalesReportEntityMapper;
import com.emazon.report.adapters.driven.mongo.repository.SalesReportMongoRepository;
import com.emazon.report.domain.model.SaleReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

class SalesReportMongoAdapterTest {

    @Mock
    private SalesReportMongoRepository salesReportMongoRepository;

    @Mock
    private SalesReportEntityMapper salesReportEntityMapper;

    @InjectMocks
    private SalesReportMongoAdapter salesReportMongoAdapter;

    private SaleReport saleReport;
    private SaleReportEntity saleReportEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a SaleReport instance for testing
        saleReport = new SaleReport(
                "SaleReportId",
                "userId",
                "userEmail",
                LocalDateTime.now(),
                BigDecimal.valueOf(100.00),
                2,
                Collections.emptyList() // Assuming no items for simplicity
        );

        // Create a corresponding SaleReportEntity instance
        saleReportEntity = new SaleReportEntity(
                "entityId",
                "userId",
                "userEmail",
                LocalDateTime.now(),
                BigDecimal.valueOf(100.00),
                2,
                Collections.emptyList() // Assuming no items for simplicity
        );
    }

    @Test
    void save_ShouldMapAndPersistSaleReport() {
        // Arrange
        when(salesReportEntityMapper.toEntity(saleReport)).thenReturn(saleReportEntity);
        when(salesReportMongoRepository.save(saleReportEntity)).thenReturn(saleReportEntity);
        when(salesReportEntityMapper.toDomain(saleReportEntity)).thenReturn(saleReport);

        // Act
        SaleReport result = salesReportMongoAdapter.save(saleReport);

        // Assert
        assertNotNull(result);
        assertEquals(saleReport.getUserId(), result.getUserId());
        assertEquals(saleReport.getUserEmail(), result.getUserEmail());
        assertEquals(saleReport.getTotalPrice(), result.getTotalPrice());
        assertEquals(saleReport.getProductCount(), result.getProductCount());

        // Verify interactions
        verify(salesReportEntityMapper).toEntity(saleReport);
        verify(salesReportMongoRepository).save(saleReportEntity);
        verify(salesReportEntityMapper).toDomain(saleReportEntity);
    }
}
