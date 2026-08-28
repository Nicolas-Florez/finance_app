package com.ravems.finance_app.service;

import com.ravems.finance_app.repository.InstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;
}
