package com.emazon.report.adapters.driving.rest.v1.mapper.request;

import com.emazon.report.adapters.driving.rest.v1.dto.request.SaleReportRequest;
import com.emazon.report.domain.model.SaleReport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalesReportRequestMapper {
    SaleReport toDomain(SaleReportRequest saleReportRequest);
    List<SaleReport> toDomains(List<SaleReportRequest> saleReportRespons);
}
