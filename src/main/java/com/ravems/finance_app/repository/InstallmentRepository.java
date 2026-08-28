package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends JpaRepository <Installment, Long> {
}
