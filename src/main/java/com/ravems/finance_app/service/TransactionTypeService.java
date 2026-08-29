package com.ravems.finance_app.service;

import com.ravems.finance_app.model.SpendingCategory;
import com.ravems.finance_app.model.TransactionType;
import com.ravems.finance_app.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public TransactionType update(Integer id, String name, Boolean isActive, String iconName){
        Optional<TransactionType> ott = transactionTypeRepository.findById(id);
        if(ott.isPresent()){
            TransactionType tt = ott.get();
            tt.setName(name);
            tt.setIsActive(isActive);
            tt.setIconName(iconName);
            return transactionTypeRepository.save(tt);
        }
        return null;
    }

    public TransactionType find(Integer id){
        Optional<TransactionType> opm = transactionTypeRepository.findById(id);
        return opm.orElse(null);
    }

    public List<TransactionType> findAll(){
        return transactionTypeRepository.findAll();
    }

    public boolean deletebyId(Integer id){
        if(transactionTypeRepository.existsById(id)){
            transactionTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
