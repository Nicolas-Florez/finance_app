package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository <PaymentMethod, Integer> {

    PaymentMethod findByName(String name);

}
