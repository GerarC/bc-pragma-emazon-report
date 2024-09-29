package com.emazon.report.adapters.driving.rest.v1.service.impl;

import com.emazon.report.adapters.driving.rest.v1.dto.request.SaleReportRequest;
import com.emazon.report.adapters.driving.rest.v1.dto.response.SaleReportResponse;
import com.emazon.report.adapters.driving.rest.v1.mapper.request.SalesReportRequestMapper;
import com.emazon.report.adapters.driving.rest.v1.mapper.response.SalesReportResponseMapper;
import com.emazon.report.adapters.driving.rest.v1.service.SalesReportService;
import com.emazon.report.domain.api.SalesReportServicePort;
import com.emazon.report.domain.model.SaleReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalesReportServiceImpl implements SalesReportService {
    private final SalesReportServicePort salesReportServicePort;
    private final SalesReportRequestMapper salesReportRequestMapper;
    private final SalesReportResponseMapper salesReportResponseMapper;

    @Override
    public SaleReportResponse save(SaleReportRequest saleReportRequest) {
        SaleReport report = salesReportRequestMapper.toDomain(saleReportRequest);
        return salesReportResponseMapper.toResponse(
                salesReportServicePort.save(report)
        );
    }
}
