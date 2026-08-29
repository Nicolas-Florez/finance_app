package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository <TransactionType, Integer> {

    TransactionType findByName(String name);
}
