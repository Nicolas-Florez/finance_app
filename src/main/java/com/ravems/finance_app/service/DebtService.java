package com.ravems.finance_app.service;

import com.ravems.finance_app.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebtService {

    @Autowired
    private DebtRepository debtRepository;
}
