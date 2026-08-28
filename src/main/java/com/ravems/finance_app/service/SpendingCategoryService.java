package com.ravems.finance_app.service;

import com.ravems.finance_app.model.PaymentMethod;
import com.ravems.finance_app.model.SpendingCategory;
import com.ravems.finance_app.repository.SpendingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpendingCategoryService {

    @Autowired
    private SpendingCategoryRepository spendingCategoryRepository;

    public SpendingCategory create(String name, Boolean isActive, String iconName){
        if(spendingCategoryRepository.findByName(name) != null){
            return null;
        }
        SpendingCategory sc = new SpendingCategory();
        sc.setName(name);
        sc.setIsActive(isActive);
        sc.setIconName(iconName);
        return spendingCategoryRepository.save(sc);
    }
}
