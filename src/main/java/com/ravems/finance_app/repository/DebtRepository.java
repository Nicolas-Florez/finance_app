package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends JpaRepository <Debt, Long> {

}
