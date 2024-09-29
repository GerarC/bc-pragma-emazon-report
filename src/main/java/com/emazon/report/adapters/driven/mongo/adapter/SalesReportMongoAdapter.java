package com.emazon.report.adapters.driven.mongo.adapter;

import com.emazon.report.adapters.driven.mongo.entity.SaleReportEntity;
import com.emazon.report.adapters.driven.mongo.mapper.SalesReportEntityMapper;
import com.emazon.report.adapters.driven.mongo.repository.SalesReportMongoRepository;
import com.emazon.report.domain.model.SaleReport;
import com.emazon.report.domain.spi.SaleReportPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalesReportMongoAdapter implements SaleReportPersistencePort {
    private final SalesReportMongoRepository salesReportMongoRepository;
    private final SalesReportEntityMapper salesReportEntityMapper;

    @Override
    public SaleReport save(SaleReport saleReport) {
        SaleReportEntity saleReportEntity = salesReportEntityMapper.toEntity(saleReport);
        return salesReportEntityMapper.toDomain(
                salesReportMongoRepository.save(saleReportEntity)
        );
    }
}
