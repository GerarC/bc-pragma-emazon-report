package com.emazon.report.domain.spi;

import com.emazon.report.domain.model.User;

public interface UserPersistencePort {
    User getCurrentUser();
}
