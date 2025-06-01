package com.mh.educationservice.controllers.responses;

public record LoginResponse(
        String key,
        String token
) {
    public static LoginResponse fromToken(String key, String token) {
        return new LoginResponse(key, token);
    }
}