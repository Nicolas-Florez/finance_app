package com.ravems.finance_app.service;

import com.ravems.finance_app.model.User;
import com.ravems.finance_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(String mail, String password,String nickname, String firstName, String middleName, String lastName, String secondSurname){
        if(userRepository.findByMailOrNickname(mail,nickname) != null){return null;}
        User user = new User();
        user.setMail(mail);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setSecondSurname(secondSurname);
        return userRepository.save(user);
    }

    public User login(String name, String password){
        User user = userRepository.findByMailOrNickname(name,name);
        if(user != null && user.getPassword().equals(password)){
            return  user;
        }
        return null;
    }

}
