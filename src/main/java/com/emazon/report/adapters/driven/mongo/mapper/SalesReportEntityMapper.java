package com.emazon.report.adapters.driven.mongo.mapper;

import com.emazon.report.adapters.driven.mongo.entity.SaleReportEntity;
import com.emazon.report.domain.model.SaleReport;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalesReportEntityMapper {
    SaleReportEntity toEntity(SaleReport saleReport);
    List<SaleReportEntity> toEntities(List<SaleReport> saleReports);
    SaleReport toDomain(SaleReportEntity saleReportEntity);
    List<SaleReport> toDomains(List<SaleReportEntity> saleReportEntities);
}
