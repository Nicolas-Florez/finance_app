package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.SpendingCategoryRequest;
import com.ravems.finance_app.dtoResponse.SpendingCategoryResponse;
import com.ravems.finance_app.model.SpendingCategory;
import com.ravems.finance_app.service.SpendingCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/spending-categories")
public class SpendingCategoryController {

    private SpendingCategoryService spendingCategoryService;

    @PostMapping
    public SpendingCategoryResponse create(@RequestBody SpendingCategoryRequest request){
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        SpendingCategory sc = spendingCategoryService.create(name,isActive,iconName);
        if(sc != null) {
            SpendingCategoryResponse scr = new SpendingCategoryResponse();
            scr.setId(sc.getSpendingCategoryId());
            scr.setName(sc.getName());
            scr.setIsActive(sc.getIsActive());
            scr.setIconName(sc.getIconName());
            return scr;
        }
        return null;
    }
}
