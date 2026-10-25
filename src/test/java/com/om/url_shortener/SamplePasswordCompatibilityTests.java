package com.om.url_shortener;

import com.om.url_shortener.config.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SamplePasswordCompatibilityTests {
    private final PasswordEncoder passwordEncoder = new WebSecurityConfig().passwordEncoder();

    @Test
    void documentedSamplePasswordsMatchTheSeedHashes() {
        assertTrue(passwordEncoder.matches("DevAdmin!2026",
                "$2a$10$Hj08phfbKMKPhUlS/kbdsuWLhuLr3mJp5u6jzF/2mnsK0lGE3wIK6"));
        assertTrue(passwordEncoder.matches("DevUser!2026",
                "$2a$10$nXCjQxTxcCO8BEN0e2KMGOKhvTyhrQpFrIfJIFkl0YtVtXo9caUBK"));
    }
}
