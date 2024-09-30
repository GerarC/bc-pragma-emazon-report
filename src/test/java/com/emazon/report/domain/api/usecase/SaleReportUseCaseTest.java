package com.emazon.report.domain.api.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.emazon.report.domain.exception.EntityNotFoundException;
import com.emazon.report.domain.model.SaleReport;
import com.emazon.report.domain.model.User;
import com.emazon.report.domain.spi.SaleReportPersistencePort;
import com.emazon.report.domain.spi.UserPersistencePort;
import com.emazon.report.domain.utils.DomainConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

class SaleReportUseCaseTest {

    @Mock
    private SaleReportPersistencePort saleReportPersistencePort;

    @Mock
    private UserPersistencePort userPersistencePort;

    @InjectMocks
    private SaleReportUseCase saleReportUseCase;

    private SaleReport saleReport;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a SaleReport instance for testing
        saleReport = new SaleReport(
                "reportId",
                null,  // userId will be set in the method
                null,  // userEmail will be set in the method
                LocalDateTime.now(),
                BigDecimal.valueOf(100.00),
                2,
                Collections.emptyList() // Assuming no items for simplicity
        );

        // Create a User instance
        user = new User("userId", "user@example.com");
    }

    @Test
    void save_ShouldSetUserIdAndUserEmail_WhenUserExists() {
        // Arrange
        when(userPersistencePort.getCurrentUser()).thenReturn(user);
        when(saleReportPersistencePort.save(any(SaleReport.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        SaleReport result = saleReportUseCase.save(saleReport);

        // Assert
        assertNotNull(result);
        assertEquals(user.getId(), result.getUserId());
        assertEquals(user.getEmail(), result.getUserEmail());
        assertEquals(saleReport.getTotalPrice(), result.getTotalPrice());
        assertEquals(saleReport.getProductCount(), result.getProductCount());

        // Verify interactions
        verify(userPersistencePort).getCurrentUser();
        verify(saleReportPersistencePort).save(saleReport);
    }

    @Test
    void save_ShouldThrowEntityNotFoundException_WhenUserDoesNotExist() {
        // Arrange
        when(userPersistencePort.getCurrentUser()).thenReturn(null);

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> saleReportUseCase.save(saleReport));
        assertEquals(DomainConstants.NOT_CURRENT_USER_MESSAGE, exception.getMessage());

        // Verify interactions
        verify(userPersistencePort).getCurrentUser();
        verify(saleReportPersistencePort, never()).save(any(SaleReport.class)); // Ensure save is not called
    }
}