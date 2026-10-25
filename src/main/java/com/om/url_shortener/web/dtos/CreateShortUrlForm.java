package com.om.url_shortener.web.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateShortUrlForm(
        @NotBlank(message = "Original URL is required")
        @Pattern(regexp = "https?://.+", message = "URL must start with http:// or https://")
        String originalUrl,
        Boolean isPrivate,
        @Min(1)
        @Max(365)
        Integer expirationInDays
) {
}
