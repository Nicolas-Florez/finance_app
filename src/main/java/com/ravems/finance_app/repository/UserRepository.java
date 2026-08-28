package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

    public User findByMailOrNickname(String mail, String nickname);

}
