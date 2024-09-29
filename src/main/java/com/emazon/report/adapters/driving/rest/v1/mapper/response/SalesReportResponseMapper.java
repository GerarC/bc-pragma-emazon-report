package com.emazon.report.adapters.driving.rest.v1.mapper.response;

import com.emazon.report.adapters.driving.rest.v1.dto.response.SaleReportResponse;
import com.emazon.report.domain.model.SaleReport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalesReportResponseMapper {
    SaleReportResponse toResponse(SaleReport saleReport);
    List<SaleReportResponse> toResponseList(List<SaleReport> saleReportList);
}
