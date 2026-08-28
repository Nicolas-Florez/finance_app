package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.DebtType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtTypeRepository extends JpaRepository <DebtType, Long> {

    DebtType findByName(String name);

}
