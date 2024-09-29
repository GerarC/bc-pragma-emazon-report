package com.emazon.report.adapters.driven.feigns.client;

import com.emazon.report.adapters.driven.feigns.dto.response.UserResponse;
import com.emazon.report.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-MICROSERVICE", url = "${emazon.user.base-url}" + "/v1/user", configuration = FeignClientConfiguration.class)
public interface UserFeign {
    @GetMapping("/token")
    UserResponse getUserByToken();
}
