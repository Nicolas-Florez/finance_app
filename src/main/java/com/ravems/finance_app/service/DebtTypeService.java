package com.ravems.finance_app.service;

import com.ravems.finance_app.model.DebtType;
import com.ravems.finance_app.repository.DebtTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebtTypeService {

    @Autowired
    private DebtTypeRepository debtTypeRepository;

    public DebtType create(String name, Boolean isActive, String iconName){
        if(debtTypeRepository.findByName(name) != null){
            return null;
        }
        DebtType dt = new DebtType();
        dt.setName(name);
        dt.setIsActive(isActive);
        dt.setIconName(iconName);
        return debtTypeRepository.save(dt);
    }
}
