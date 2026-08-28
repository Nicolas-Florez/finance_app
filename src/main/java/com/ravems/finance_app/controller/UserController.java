package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.LoginRequest;
import com.ravems.finance_app.dtoResponse.LoginResponse;
import com.ravems.finance_app.dtoRequest.RegisterRequest;
import com.ravems.finance_app.model.User;
import com.ravems.finance_app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public LoginResponse registerUser(@RequestBody RegisterRequest request) {
        String mail = request.getMail();
        String password = request.getPassword();
        String nickname = request.getNickname();
        String fn = request.getFirstName();
        String mn = request.getMiddleName();
        String ln = request.getLastName();
        String ss = request.getSecondSurname();
        User user = userService.register(mail, password, nickname, fn, mn, ln, ss);
        if (user != null) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUserId(user.getUserId());
            loginResponse.setMail(user.getMail());
            loginResponse.setNickname(user.getNickname());
            loginResponse.setFirstName(user.getFirstName());
            loginResponse.setMiddleName(user.getMiddleName());
            loginResponse.setLastName(user.getLastName());
            loginResponse.setSecondSurname(user.getSecondSurname());
            loginResponse.setCreatedAt(user.getCreatedAt());
            return loginResponse;
        }
        return null;
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request) {
        String name = request.getName();
        String password = request.getPassword();
        User user =  userService.login(name, password);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getUserId());
        loginResponse.setMail(user.getMail());
        loginResponse.setNickname(user.getNickname());
        loginResponse.setFirstName(user.getFirstName());
        loginResponse.setMiddleName(user.getMiddleName());
        loginResponse.setLastName(user.getLastName());
        loginResponse.setSecondSurname(user.getSecondSurname());
        loginResponse.setCreatedAt(user.getCreatedAt());
        return loginResponse;
    }

}
