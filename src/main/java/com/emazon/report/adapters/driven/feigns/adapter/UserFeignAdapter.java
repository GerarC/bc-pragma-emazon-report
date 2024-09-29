package com.emazon.report.adapters.driven.feigns.adapter;

import com.emazon.report.adapters.driven.feigns.client.UserFeign;
import com.emazon.report.adapters.driven.feigns.mapper.response.UserResponseMapper;
import com.emazon.report.domain.model.User;
import com.emazon.report.domain.spi.UserPersistencePort;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFeignAdapter implements UserPersistencePort {
    private final UserFeign userFeign;
    private final UserResponseMapper userResponseMapper;

    @Override
    public User getCurrentUser() {
        try {
            return userResponseMapper.toDomain(
                    userFeign.getUserByToken()
            );
        } catch (FeignException e) {
            return null;
        }
    }
}