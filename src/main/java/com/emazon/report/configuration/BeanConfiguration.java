package com.emazon.report.configuration;

import com.emazon.report.domain.api.SalesReportServicePort;
import com.emazon.report.domain.api.usecase.SaleReportUseCase;
import com.emazon.report.domain.spi.SaleReportPersistencePort;
import com.emazon.report.domain.spi.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserDetailsService userDetailsService;
    private final UserPersistencePort userPersistencePort;
    private final SaleReportPersistencePort saleReportPersistencePort;

    @Bean
    SalesReportServicePort salesReportServicePort(){
        return new SaleReportUseCase(saleReportPersistencePort, userPersistencePort);
    }


    // security
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

}
