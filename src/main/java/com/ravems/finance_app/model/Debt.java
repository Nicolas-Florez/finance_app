package com.ravems.finance_app.model;

import com.ravems.finance_app.enums.DebtsStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity representing a debt or financial obligation stored in the 'debts' database table.
 */
@Entity
@Data
@Table(name = "debts")
public class Debt {

    /**
     * Unique identifier for the debt (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "debt_id",
            comment = "Unique primary key identifier for the debt record"
    )
    private Long debtId;

    /**
     * Original principal monetary amount borrowed or owed.
     */
    @Column(
            name = "original_amount",
            precision = 18,
            scale = 0,
            nullable = false,
            comment = "Original principal monetary amount of the debt"
    )
    private BigDecimal originalAmount;

    /**
     * Optional text description or notes regarding the debt.
     */
    @Column(
            name = "description",
            comment = "Optional text description or notes about the debt"
    )
    private String description;

    /**
     * Obligatory title describing the purpose of the debt.
     */
    @Column(
            name = "name",
            comment = "Obligatory text title for the debt"
    )
    private String name;

    /**
     * Total number of scheduled installments for repaying the debt.
     */
    @Column(
            name = "installment_count",
            nullable = false,
            comment = "Total number of scheduled repayment installments"
    )
    private Integer installmentsCount;

    /**
     * Inception or starting date of the debt contract.
     */
    @Column(
            name = "local_Date",
            nullable = false,
            comment = "Start or inception date of the debt obligation"
    )
    private LocalDate startDate;

    /**
     * Timestamp recording when the debt entry was created in the database.
     */
    @CreationTimestamp
    @Column(
            name = "created_at",
            updatable = false,
            comment = "Timestamp recording when the debt record was created"
    )
    private LocalDateTime createdAt;

    /**
     * Current debt status of the installment (e.g., PENDING, PAID, IN_LATE).
     */
    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false,
            comment = "Current status of the debt"
    )
    private DebtsStatus status;

    /**
     * Classification or type of the debt (e.g., Credit Card, Personal Loan).
     */
    @ManyToOne
    @JoinColumn(
            name = "type_debt_id",
            nullable = false,
            comment = "Foreign key referencing the type of debt"
    )
    private DebtType typeDebt;

    /**
     * User who incurred or holds responsibility for this debt.
     */
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            comment = "Foreign key referencing the user who owns this debt"
    )
    private User user;

}