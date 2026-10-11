package com.ravems.finance_app.repository;

import com.ravems.finance_app.enums.InstallmentStatus;
import com.ravems.finance_app.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstallmentRepository extends JpaRepository <Installment, Long> {

    List<Installment> findByDebt_DebtIdAndStatusOrderByInstallmentNumberAsc(Long debtId, InstallmentStatus status);

    @Query("SELECT i FROM Installment i " +
            "WHERE i.debt.debtId = :debtId AND i.status = :status " +
            "ORDER BY i.installmentNumber ASC")
    List<Installment> getPendingInstallments(Long debtId, InstallmentStatus status);
}
