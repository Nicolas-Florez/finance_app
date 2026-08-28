package com.ravems.finance_app.service;

import com.ravems.finance_app.model.PaymentMethod;
import com.ravems.finance_app.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod create(String name, Boolean isActive, String iconName){
        if(paymentMethodRepository.findByName(name) != null){
            return null;
        }
        PaymentMethod pm = new PaymentMethod();
        pm.setName(name);
        pm.setIsActive(isActive);
        pm.setIconName(iconName);
        return paymentMethodRepository.save(pm);
    }

}
