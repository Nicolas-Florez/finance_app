package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.DebtTypeRequest;
import com.ravems.finance_app.dtoResponse.DebtTypeResponse;
import com.ravems.finance_app.model.DebtType;
import com.ravems.finance_app.service.DebtTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    @RequestMapping("/api/admin/debt-types")
public class DebtTypeController {

    @Autowired
    private DebtTypeService debtTypeService;

    @PostMapping
    public DebtTypeResponse create(@Validated @RequestBody DebtTypeRequest request) {
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        DebtType dt = debtTypeService.create(name, isActive, iconName);
        if (dt != null) {
            DebtTypeResponse dtr = new DebtTypeResponse();
            dtr.setId(dt.getDebtTypeId());
            dtr.setName(dt.getName());
            dtr.setIsActive(dt.getIsActive());
            dtr.setIconName(dt.getIconName());
            return dtr;
        }
        return null;
    }

    @PutMapping("/{id}")
    public DebtTypeResponse update(@Validated @RequestBody DebtTypeRequest request, @PathVariable Integer id) {
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        DebtType dt = debtTypeService.update(id, name, isActive, iconName);
        if (dt != null) {
            DebtTypeResponse dtr = new DebtTypeResponse();
            dtr.setId(dt.getDebtTypeId());
            dtr.setName(dt.getName());
            dtr.setIsActive(dt.getIsActive());
            dtr.setIconName(dt.getIconName());
            return dtr;
        }
        return null;
    }

    @GetMapping("/{id}")
    public DebtTypeResponse find(@PathVariable Integer id) {
        DebtType dt = debtTypeService.find(id);
        if (dt != null) {
            DebtTypeResponse dtr = new DebtTypeResponse();
            dtr.setId(dt.getDebtTypeId());
            dtr.setName(dt.getName());
            dtr.setIsActive(dt.getIsActive());
            dtr.setIconName(dt.getIconName());
            return dtr;
        }
        return null;
    }

    @GetMapping
    public List<DebtTypeResponse> findAll() {
        List<DebtType> dtl = debtTypeService.findAll();
        List<DebtTypeResponse> dtrl = new ArrayList<>();
        for (DebtType dt : dtl) {
            DebtTypeResponse dtr = new DebtTypeResponse();
            dtr.setId(dt.getDebtTypeId());
            dtr.setName(dt.getName());
            dtr.setIsActive(dt.getIsActive());
            dtr.setIconName(dt.getIconName());
            dtrl.add(dtr);
        }
        return dtrl;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        if(debtTypeService.deletebyId(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

}
