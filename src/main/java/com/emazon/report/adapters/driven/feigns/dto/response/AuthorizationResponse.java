package com.emazon.report.adapters.driven.feigns.dto.response;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {
    private boolean authorized;
    private String email;
    private String role;
}
