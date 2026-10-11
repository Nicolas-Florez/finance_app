package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.Installment;
import com.ravems.finance_app.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {

    List<Transaction> findByDebt_DebtIdOrderByCreatedAtDesc(Long debtId);
}
