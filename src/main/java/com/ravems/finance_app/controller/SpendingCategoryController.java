package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.SpendingCategoryRequest;
import com.ravems.finance_app.dtoResponse.SpendingCategoryResponse;
import com.ravems.finance_app.model.SpendingCategory;
import com.ravems.finance_app.service.SpendingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/spending-categories")
public class SpendingCategoryController {

    @Autowired
    private SpendingCategoryService spendingCategoryService;

    @PostMapping
    public SpendingCategoryResponse create(@Validated  @RequestBody SpendingCategoryRequest request){
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

    @PutMapping("/{id}")
    public SpendingCategoryResponse update(@Validated @RequestBody SpendingCategoryRequest request, @PathVariable Integer id){
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        SpendingCategory sc = spendingCategoryService.update(id,name,isActive,iconName);
        if(sc != null){
            SpendingCategoryResponse scr = new SpendingCategoryResponse();
            scr.setId(sc.getSpendingCategoryId());
            scr.setName(sc.getName());
            scr.setIsActive(sc.getIsActive());
            scr.setIconName(sc.getIconName());
            return scr;
        }
        return null;
    }
    
    @GetMapping("/{id}")
    public SpendingCategoryResponse find(@PathVariable Integer id) {
        SpendingCategory sc = spendingCategoryService.find(id);
        if (sc != null) {
            SpendingCategoryResponse scr = new SpendingCategoryResponse();
            scr.setId(sc.getSpendingCategoryId());
            scr.setName(sc.getName());
            scr.setIsActive(sc.getIsActive());
            scr.setIconName(sc.getIconName());
            return scr;
        }
        return null;
    }

    @GetMapping
    public List<SpendingCategoryResponse> findAll() {
        List<SpendingCategory> pml = spendingCategoryService.findAll();
        List<SpendingCategoryResponse> scrl = new ArrayList<>();
        for (SpendingCategory sc : pml) {
            SpendingCategoryResponse scr = new SpendingCategoryResponse();
            scr.setId(sc.getSpendingCategoryId());
            scr.setName(sc.getName());
            scr.setIsActive(sc.getIsActive());
            scr.setIconName(sc.getIconName());
            scrl.add(scr);
        }
        return scrl;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        if(spendingCategoryService.deletebyId(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
