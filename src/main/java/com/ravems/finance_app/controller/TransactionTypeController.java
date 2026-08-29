package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.TransactionTypeRequest;
import com.ravems.finance_app.dtoResponse.TransactionTypeResponse;
import com.ravems.finance_app.model.TransactionType;
import com.ravems.finance_app.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/transaction-types")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @PostMapping
    public TransactionTypeResponse create(@Validated @RequestBody TransactionTypeRequest request){
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

    @PutMapping("/{id}")
    public TransactionTypeResponse update(@Validated @RequestBody TransactionTypeRequest request, @PathVariable Integer id){
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        TransactionType tt = transactionTypeService.update(id,name,isActive,iconName);
        if(tt != null){
            TransactionTypeResponse ttr = new TransactionTypeResponse();
            ttr.setId(tt.getTransactionTypeId());
            ttr.setName(tt.getName());
            ttr.setIsActive(tt.getIsActive());
            ttr.setIconName(tt.getIconName());
            return ttr;
        }
        return null;
    }

    @GetMapping("/{id}")
    public TransactionTypeResponse find(@PathVariable Integer id) {
        TransactionType tt = transactionTypeService.find(id);
        if (tt != null) {
            TransactionTypeResponse ttr = new TransactionTypeResponse();
            ttr.setId(tt.getTransactionTypeId());
            ttr.setName(tt.getName());
            ttr.setIsActive(tt.getIsActive());
            ttr.setIconName(tt.getIconName());
            return ttr;
        }
        return null;
    }

    @GetMapping
    public List<TransactionTypeResponse> findAll() {
        List<TransactionType> pml = transactionTypeService.findAll();
        List<TransactionTypeResponse> ttrl = new ArrayList<>();
        for (TransactionType tt : pml) {
            TransactionTypeResponse ttr = new TransactionTypeResponse();
            ttr.setId(tt.getTransactionTypeId());
            ttr.setName(tt.getName());
            ttr.setIsActive(tt.getIsActive());
            ttr.setIconName(tt.getIconName());
            ttrl.add(ttr);
        }
        return ttrl;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        if(transactionTypeService.deletebyId(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
