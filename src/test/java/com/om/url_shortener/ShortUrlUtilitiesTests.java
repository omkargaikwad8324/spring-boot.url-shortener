package com.om.url_shortener;

import com.om.url_shortener.domain.services.RandomUtils;
import com.om.url_shortener.domain.services.UrlValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortUrlUtilitiesTests {

    @Test
    void generatedShortKeysMatchTheDatabaseKeyFormat() {
        String key = RandomUtils.generateRandomShortKey();

        assertEquals(6, key.length());
        assertTrue(key.matches("[A-Za-z0-9]{6}"));
    }

    @Test
    void acceptsOnlyAbsoluteHttpAndHttpsUrlsWithAHost() {
        assertTrue(UrlValidator.isValidHttpUrl("https://example.com/path"));
        assertTrue(UrlValidator.isValidHttpUrl("http://localhost:8080"));
        assertFalse(UrlValidator.isValidHttpUrl("javascript:alert(1)"));
        assertFalse(UrlValidator.isValidHttpUrl("https:///missing-host"));
        assertFalse(UrlValidator.isValidHttpUrl("not a URL"));
    }
}
