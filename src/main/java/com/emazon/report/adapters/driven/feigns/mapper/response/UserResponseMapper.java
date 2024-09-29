package com.emazon.report.adapters.driven.feigns.mapper.response;

import com.emazon.report.adapters.driven.feigns.dto.response.UserResponse;
import com.emazon.report.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    User toDomain(UserResponse userResponse);
}
