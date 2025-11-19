package com.ali.skeletonV1.config;

import com.ali.skeletonV1.constant.SystemConstant;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Component
public class SystemConfig {



    /**
     * Swagger API.
     * Swagger API Info Configuration
     * Project Title,Description,Version
     */
    @Bean
    public OpenAPI swaggerAPI() {
        return new OpenAPI()
                .info(new Info().title(SystemConstant.SWAGGER_TITLE)
                        .description(SystemConstant.SWAGGER_DESCRIPTION)
                        .version(SystemConstant.SWAGGER_VERSION));
    }



    /**
     * Initiated for Locale Resolver Object
     * and Set the Default Language as English US
     */
    @Bean
    public LocaleResolver localeResolver() {
        final SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }
}
