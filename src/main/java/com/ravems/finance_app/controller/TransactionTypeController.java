package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.SpendingCategoryRequest;
import com.ravems.finance_app.dtoRequest.TransactionTypeRequest;
import com.ravems.finance_app.dtoResponse.SpendingCategoryResponse;
import com.ravems.finance_app.dtoResponse.TransactionTypeResponse;
import com.ravems.finance_app.model.SpendingCategory;
import com.ravems.finance_app.model.TransactionType;
import com.ravems.finance_app.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/transaction-types")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @PostMapping
    public TransactionTypeResponse create(@RequestBody TransactionTypeRequest request){
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        TransactionType tt = transactionTypeService.create(name,isActive,iconName);
        if(tt != null) {
            TransactionTypeResponse ttr = new TransactionTypeResponse();
            ttr.setId(tt.getTransactionTypeId());
            ttr.setName(tt.getName());
            ttr.setIsActive(tt.getIsActive());
            ttr.setIconName(tt.getIconName());
            return ttr;
        }
        return null;
    }
}
