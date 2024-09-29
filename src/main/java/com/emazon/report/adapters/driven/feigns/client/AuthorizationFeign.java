package com.emazon.report.adapters.driven.feigns.client;

import com.emazon.report.adapters.driven.feigns.dto.request.AuthorizationRequest;
import com.emazon.report.adapters.driven.feigns.dto.response.AuthorizationResponse;
import com.emazon.report.configuration.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUTH-MICROSERVICE", url = "${emazon.user.base-url}" + "/v1/auth", configuration = FeignClientConfiguration.class)
public interface AuthorizationFeign {
    @PostMapping(value = "/authorize", consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorizationResponse authorize(@RequestBody AuthorizationRequest authorizationRequest);
}
