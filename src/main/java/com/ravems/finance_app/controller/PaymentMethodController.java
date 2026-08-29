package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.PaymentMethodRequest;
import com.ravems.finance_app.dtoResponse.PaymentMethodResponse;
import com.ravems.finance_app.model.PaymentMethod;
import com.ravems.finance_app.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping
    public PaymentMethodResponse create(@Validated @RequestBody PaymentMethodRequest request){
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        PaymentMethod pm = paymentMethodService.create(name,isActive,iconName);
            if(pm != null) {
                PaymentMethodResponse pmr = new PaymentMethodResponse();
                pmr.setId(pm.getPaymentMethodId());
                pmr.setName(pm.getName());
                pmr.setIsActive(pm.getIsActive());
                pmr.setIconName(pm.getIconName());
                return pmr;
            }
        return null;
    }

    @PutMapping("/{id}")
    public PaymentMethodResponse update(@Validated @RequestBody PaymentMethodRequest request, @PathVariable Integer id){
        String name = request.getName();
        Boolean isActive = request.getIsActive();
        String iconName = request.getIconName();
        PaymentMethod pm = paymentMethodService.update(id,name,isActive,iconName);
        if(pm != null){
            PaymentMethodResponse pmr = new PaymentMethodResponse();
            pmr.setId(pm.getPaymentMethodId());
            pmr.setName(pm.getName());
            pmr.setIsActive(pm.getIsActive());
            pmr.setIconName(pm.getIconName());
            return pmr;
        }
        return null;
    }

    @GetMapping("/{id}")
    public PaymentMethodResponse find(@PathVariable Integer id) {
        PaymentMethod pm = paymentMethodService.find(id);
        if (pm != null) {
            PaymentMethodResponse pmr = new PaymentMethodResponse();
            pmr.setId(pm.getPaymentMethodId());
            pmr.setName(pm.getName());
            pmr.setIsActive(pm.getIsActive());
            pmr.setIconName(pm.getIconName());
            return pmr;
        }
        return null;
    }

    @GetMapping
    public List<PaymentMethodResponse> findAll() {
        List<PaymentMethod> pml = paymentMethodService.findAll();
        List<PaymentMethodResponse> pmrl = new ArrayList<>();
        for (PaymentMethod pm : pml) {
            PaymentMethodResponse pmr = new PaymentMethodResponse();
            pmr.setId(pm.getPaymentMethodId());
            pmr.setName(pm.getName());
            pmr.setIsActive(pm.getIsActive());
            pmr.setIconName(pm.getIconName());
            pmrl.add(pmr);
        }
        return pmrl;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        if(paymentMethodService.deletebyId(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
