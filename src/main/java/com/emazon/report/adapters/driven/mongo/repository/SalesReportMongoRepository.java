package com.emazon.report.adapters.driven.mongo.repository;

import com.emazon.report.adapters.driven.mongo.entity.SaleReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReportMongoRepository extends MongoRepository<SaleReportEntity, String> {
}
