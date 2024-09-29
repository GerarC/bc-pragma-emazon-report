package com.emazon.report.adapters.driving.rest.v1.controller;

import com.emazon.report.adapters.driving.rest.v1.dto.request.SaleReportRequest;
import com.emazon.report.adapters.driving.rest.v1.dto.response.SaleReportResponse;
import com.emazon.report.adapters.driving.rest.v1.service.SalesReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sale-reports")
public class SaleReportController {
    private final SalesReportService salesReportService;

    @PostMapping
    public ResponseEntity<SaleReportResponse> save(@RequestBody @Valid SaleReportRequest saleReportRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                salesReportService.save(saleReportRequest)
        );
    }

}
