package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.DebtTypeRequest;
import com.ravems.finance_app.dtoResponse.DebtTypeResponse;
import com.ravems.finance_app.model.DebtType;
import com.ravems.finance_app.service.DebtTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/debt-types")
public class DebtTypeController {

    @Autowired
    private DebtTypeService debtTypeService;

    @PostMapping
    public DebtTypeResponse create(@RequestBody DebtTypeRequest request){
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        DebtType pm = debtTypeService.create(name,isActive,iconName);
        if(pm != null) {
            DebtTypeResponse dtr = new DebtTypeResponse();
            dtr.setId(pm.getDebtTypeId());
            dtr.setName(pm.getName());
            dtr.setIsActive(pm.getIsActive());
            dtr.setIconName(pm.getIconName());
            return dtr;
        }
        return null;
    }
}
