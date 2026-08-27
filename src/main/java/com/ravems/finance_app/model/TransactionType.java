package com.ravems.finance_app.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity representing a type of transaction stored in the 'transaction_type' database table.
 */
@Entity
@Data
@Table(name = "transaction_type")
public class TransactionType {

    /**
     * Unique identifier for the transaction type (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "transaction_type_id",
            comment = "Unique primary key identifier for the transaction type"
    )
    private Integer transactionTypeId;

    /**
     * Name or label describing the transaction type (e.g., Income, Expense).
     */
    @Column(
            name = "name",
            nullable = false,
            comment = "Name or label of the transaction type"
    )
    private String name;

    /**
     * Flag indicating whether the transaction type is currently active and available.
     */
    @Column(
            name = "is_active",
            nullable = false,
            comment = "Flag indicating whether the transaction type is active"
    )
    private Boolean isActive;

    /**
     * Name or identifier of the icon representing this transaction type in the UI.
     */
    @Column(
            name = "icon_name",
            nullable = false,
            comment = "Identifier or filename of the icon associated with this transaction type"
    )
    private String iconName;

}