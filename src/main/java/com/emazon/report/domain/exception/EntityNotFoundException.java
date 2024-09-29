package com.emazon.report.domain.exception;

import com.emazon.report.domain.utils.DomainConstants;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String className, String id) {
        super(String.format(DomainConstants.ENTITY_NOT_FOUND_MESSAGE, className, id));
    }
}
