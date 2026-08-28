package com.ravems.finance_app.dtoRequest;


import lombok.Data;

@Data
public class RegisterRequest {
    private String mail;
    private String password;
    private String nickname;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondSurname;
}
