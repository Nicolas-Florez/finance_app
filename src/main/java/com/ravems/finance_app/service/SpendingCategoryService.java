package com.ravems.finance_app.service;

import com.ravems.finance_app.model.PaymentMethod;
import com.ravems.finance_app.model.SpendingCategory;
import com.ravems.finance_app.repository.SpendingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public SpendingCategory update(Integer id, String name, Boolean isActive, String iconName){
        Optional<SpendingCategory> osc = spendingCategoryRepository.findById(id);
        if(osc.isPresent()){
            SpendingCategory sc = osc.get();
            sc.setName(name);
            sc.setIsActive(isActive);
            sc.setIconName(iconName);
            return spendingCategoryRepository.save(sc);
        }
        return null;
    }

    public SpendingCategory find(Integer id){
        Optional<SpendingCategory> opm = spendingCategoryRepository.findById(id);
        return opm.orElse(null);
    }

    public List<SpendingCategory> findAll(){
        return spendingCategoryRepository.findAll();
    }

    public boolean deletebyId(Integer id){
        if(spendingCategoryRepository.existsById(id)){
            spendingCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
