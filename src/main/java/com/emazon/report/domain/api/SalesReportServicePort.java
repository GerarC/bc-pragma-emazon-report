package com.emazon.report.domain.api;

import com.emazon.report.domain.model.SaleReport;

public interface SalesReportServicePort {
    SaleReport save(SaleReport saleReport);
}
