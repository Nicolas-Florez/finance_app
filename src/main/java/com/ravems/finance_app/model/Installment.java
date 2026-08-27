package com.ravems.finance_app.model;

import com.ravems.finance_app.Enums.InstallmentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity representing a debt installment payment stored in the 'installment' database table.
 */
@Entity
@Data
@Table(name = "installment")
public class Installment {

    /**
     * Unique identifier for the installment (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "installment_id",
            comment = "Unique primary key identifier for the installment record"
    )
    private Long installmentId;

    /**
     * Sequential position or number of this installment in the payment schedule (e.g., 1, 2, 3).
     */
    @Column(
            name = "installment_number",
            comment = "Sequential position or index number of this installment"
    )
    private Integer installmentNumber;

    /**
     * Monetary amount scheduled to be paid for this installment.
     */
    @Column(
            name = "amount_due",
            comment = "Total monetary amount due for this specific installment"
    )
    private BigDecimal amountDue;

    /**
     * Monetary amount that has actually been paid towards this installment.
     */
    @Column(
            name = "amount_paid",
            comment = "Monetary amount already paid towards this installment"
    )
    private BigDecimal amountPaid;

    /**
     * Target date by which this installment must be paid.
     */
    @Column(
            name = "due_date",
            comment = "Scheduled due date for payment completion"
    )
    private LocalDate dueDate;

    /**
     * Current payment status of the installment (e.g., PENDING, PAID, OVERDUE).
     */
    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false,
            comment = "Current status of the installment payment"
    )
    private InstallmentStatus status;

    /**
     * Parent debt contract or agreement to which this installment belongs.
     */
    @ManyToOne
    @JoinColumn(
            name = "debt_id",
            comment = "Foreign key referencing the parent debt record"
    )
    private Debt debt;

}