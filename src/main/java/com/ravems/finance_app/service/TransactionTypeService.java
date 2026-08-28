package com.ravems.finance_app.service;

import com.ravems.finance_app.model.SpendingCategory;
import com.ravems.finance_app.model.TransactionType;
import com.ravems.finance_app.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public TransactionType create(String name, Boolean isActive, String iconName){
        if(transactionTypeRepository.findByName(name) != null){
            return null;
        }
        TransactionType tt = new TransactionType();
        tt.setName(name);
        tt.setIsActive(isActive);
        tt.setIconName(iconName);
        return transactionTypeRepository.save(tt);
    }
}
