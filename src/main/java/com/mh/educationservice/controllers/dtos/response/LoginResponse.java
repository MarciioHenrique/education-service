package com.mh.educationservice.controllers.dtos.response;

public record LoginResponse(
        String token
) {
    public static LoginResponse fromToken(String token) {
        return new LoginResponse(token);
    }
}