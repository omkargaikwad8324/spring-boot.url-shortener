package com.om.url_shortener.domain.models;


public record CreateUserCmd(
        String email,
        String password,
        String name,
        Role role) {
}