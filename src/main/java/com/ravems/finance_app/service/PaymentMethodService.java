package com.ravems.finance_app.service;

import com.ravems.finance_app.model.DebtType;
import com.ravems.finance_app.model.PaymentMethod;
import com.ravems.finance_app.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public PaymentMethod update(Integer id, String name, Boolean isActive, String iconName){
        Optional<PaymentMethod> opm = paymentMethodRepository.findById(id);
        if(opm.isPresent()){
            PaymentMethod pm = opm.get();
            pm.setName(name);
            pm.setIsActive(isActive);
            pm.setIconName(iconName);
            return paymentMethodRepository.save(pm);
        }
        return null;
    }

    public PaymentMethod find(Integer id){
        Optional<PaymentMethod> opm = paymentMethodRepository.findById(id);
        return opm.orElse(null);
    }

    public List<PaymentMethod> findAll(){
        return paymentMethodRepository.findAll();
    }

    public boolean deletebyId(Integer id){
        if(paymentMethodRepository.existsById(id)){
            paymentMethodRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
