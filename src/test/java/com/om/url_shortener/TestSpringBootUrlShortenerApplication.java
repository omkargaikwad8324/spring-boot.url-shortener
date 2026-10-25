package com.om.url_shortener;

import org.springframework.boot.SpringApplication;

class TestSpringBootUrlShortenerApplication {

    public static void main(String[] args) {
        SpringApplication
                .from(Application::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }
}
