package com.ravems.finance_app.dtoResponse;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginResponse {
    private Long userId;
    private String mail;
    private String nickname;
    private String firstName, middleName, lastName, secondSurname;
    private LocalDateTime createdAt;
}
