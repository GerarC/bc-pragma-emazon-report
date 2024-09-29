package com.emazon.report.domain.spi;

import com.emazon.report.domain.model.SaleReport;

public interface SaleReportPersistencePort {
    SaleReport save(SaleReport saleReport);
}
