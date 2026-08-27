package com.ravems.finance_app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity representing a financial transaction stored in the 'transactions' database table.
 */
@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    /**
     * Unique identifier for the transaction (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "transaction_id",
            comment = "Unique primary key identifier for the transaction record"
    )
    private Long transactionId;

    /**
     * Monetary value or amount involved in the transaction.
     */
    @Column(
            name = "amount",
            comment = "Monetary amount involved in the transaction"
    )
    private BigDecimal amount;

    /**
     * Obligatory title describing the purpose of the transaction.
     */
    @Column(
            name = "name",
            comment = "Obligatory text title for the transaction"
    )
    private String name;

    /**
     * Optional detail or memo describing the purpose of the transaction.
     */
    @Column(
            name = "description",
            comment = "Optional text description or memo for the transaction"
    )
    private String description;

    /**
     * Date and time when the transaction actually took place.
     */
    @Column(
            name = "transaction_date",
            comment = "Date and time when the transaction occurred"
    )
    private LocalDateTime transactionDate;

    /**
     * Timestamp recording when the transaction entry was inserted into the system.
     */
    @CreationTimestamp
    @Column(
            name = "created_at",
            comment = "Timestamp recording when the record was created"
    )
    private LocalDateTime createdAt;

    // Relations

    /**
     * User who owns or registered this transaction.
     */
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            comment = "Foreign key referencing the user who owns this transaction"
    )
    private User user;

    /**
     * Classification type of the transaction (e.g., Income, Expense).
     */
    @ManyToOne
    @JoinColumn(
            name = "transaction_type_id",
            nullable = false,
            comment = "Foreign key referencing the type of transaction"
    )
    private TransactionType transactionType;

    /**
     * Payment method used for the transaction (e.g., Cash, Credit Card, Bank Transfer).
     */
    @ManyToOne
    @JoinColumn(
            name = "payment_method_id",
            nullable = false,
            comment = "Foreign key referencing the payment method used"
    )
    private PaymentMethod paymentMethod;

    /**
     * Category under which this spending or income is categorized.
     */
    @ManyToOne
    @JoinColumn(
            name = "spending_category_id",
            nullable = false,
            comment = "Foreign key referencing the spending category"
    )
    private SpendingCategory spendingCategory;

    @ManyToOne
    @JoinColumn (name = "debt_id",nullable = true)
    private Debt debt;

}