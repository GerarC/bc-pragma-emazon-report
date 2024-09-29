package com.emazon.report.domain.api.usecase;

import com.emazon.report.domain.api.SalesReportServicePort;
import com.emazon.report.domain.exception.EntityNotFoundException;
import com.emazon.report.domain.model.SaleReport;
import com.emazon.report.domain.model.User;
import com.emazon.report.domain.spi.SaleReportPersistencePort;
import com.emazon.report.domain.spi.UserPersistencePort;
import com.emazon.report.domain.utils.DomainConstants;

public class SaleReportUseCase implements SalesReportServicePort {
    private final SaleReportPersistencePort saleReportPersistencePort;
    private final UserPersistencePort userPersistencePort;

    public SaleReportUseCase(SaleReportPersistencePort saleReportPersistencePort, UserPersistencePort userPersistencePort) {
        this.saleReportPersistencePort = saleReportPersistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public SaleReport save(SaleReport saleReport) {
        User user = userPersistencePort.getCurrentUser();
        if(user == null) throw  new EntityNotFoundException(DomainConstants.NOT_CURRENT_USER_MESSAGE);
        saleReport.setUserId(user.getId());
        saleReport.setUserEmail(user.getEmail());
        return saleReportPersistencePort.save(saleReport);
    }
}
