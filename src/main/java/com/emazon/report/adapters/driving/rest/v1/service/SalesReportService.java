package com.emazon.report.adapters.driving.rest.v1.service;

import com.emazon.report.adapters.driving.rest.v1.dto.request.SaleReportRequest;
import com.emazon.report.adapters.driving.rest.v1.dto.response.SaleReportResponse;

public interface SalesReportService {
    SaleReportResponse save(SaleReportRequest saleReportRequest);
}
