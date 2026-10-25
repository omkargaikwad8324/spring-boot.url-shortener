package com.om.url_shortener.domain.services;

import java.net.URI;

public final class UrlValidator {
    private UrlValidator() {
    }

    public static boolean isValidHttpUrl(String urlString) {
        try {
            URI uri = new URI(urlString);
            return ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()))
                    && uri.getHost() != null;
        } catch (Exception e) {
            return false;
        }
    }
}
