package com.ravems.finance_app.controller;

import com.ravems.finance_app.dtoRequest.PaymentMethodRequest;
import com.ravems.finance_app.dtoResponse.PaymentMethodResponse;
import com.ravems.finance_app.model.PaymentMethod;
import com.ravems.finance_app.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping
    public PaymentMethodResponse create(@RequestBody PaymentMethodRequest request){
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
}
