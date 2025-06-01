package com.mh.educationservice.controllers.responses;

public record LoginResponse(
        String token
) {
    public static LoginResponse fromToken(String token) {
        return new LoginResponse(token);
    }
}