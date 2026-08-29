package com.ravems.finance_app.service;

import com.ravems.finance_app.model.DebtType;
import com.ravems.finance_app.repository.DebtTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public DebtType update(Integer id,String name, Boolean isActive, String iconName){
        Optional<DebtType> odt = debtTypeRepository.findById(id);
        if(odt.isPresent()){
            DebtType dt = odt.get();
            dt.setName(name);
            dt.setIsActive(isActive);
            dt.setIconName(iconName);
            return debtTypeRepository.save(dt);
        }
        return null;
    }

    public DebtType find(Integer id){
        Optional<DebtType> odt = debtTypeRepository.findById(id);
        return odt.orElse(null);
    }

    public List<DebtType> findAll(){
        return debtTypeRepository.findAll();
    }

    public boolean deletebyId(Integer id){
        if(debtTypeRepository.existsById(id)){
            debtTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
