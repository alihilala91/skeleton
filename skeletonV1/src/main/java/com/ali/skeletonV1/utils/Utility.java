package com.ali.skeletonV1.utils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Locale;

public class Utility {


    /**
     * Get Locale form the Http Servlet Request
     *
     * @param request HttpServletRequest
     * @return Locale
     */
    public static Locale getLocale(final HttpServletRequest request) {

        if (request.getLocale() != null) {
            return request.getLocale();
        }
        return Locale.ENGLISH;
    }
}
