package com.ali.skeletonV1.utils;

import com.ali.skeletonV1.enums.employee.EmployeeIdentificationTypeEnums;
import com.ali.skeletonV1.exception.ExceptionKey;
import com.ali.skeletonV1.exception.ResourceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public class Utility {


    /**
     * Get Locale form the Http Servlet Request
     *
     * @param request HttpServletRequest
     * @return Locale
     */
    public static Locale getLocale(final HttpServletRequest request) {

        if (request != null && request.getLocale() != null) {
            return request.getLocale();
        }
        return Locale.ENGLISH;
    }

    /**
     * Validate the Identification Type
     *
     * @param identificationType Identification Type
     * @param locale             Locale
     */
    public static void validateIdentificationType(final String identificationType, Locale locale) {

        try {
            // Validate the Identification Type
            EmployeeIdentificationTypeEnums.valueOf(identificationType);
        } catch (final Exception e) {

            // Throw Resource Exception for Invalid Identification Type
            throw new ResourceException(ExceptionKey.EMPLOYEE_IDENTIFICATION_TYPE_NOT_VALID,
                    HttpStatus.NOT_ACCEPTABLE, locale);

        }
    }
}
