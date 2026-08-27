package com.ravems.finance_app.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity representing a debt type stored in the 'debt_types' database table.
 */
@Entity
@Data
@Table(name = "debt_types")
public class DebtType {

    /**
     * Unique identifier for the debt type (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "debt_type_id",
            comment = "Unique primary key identifier for the debt type"
    )
    private Integer debtTypeId;

    /**
     * Name or label of the debt type (e.g., Credit Card, Personal Loan, Mortgage).
     */
    @Column(
            name = "name",
            nullable = false,
            comment = "Name or label of the debt type"
    )
    private String name;

    /**
     * Flag indicating whether the debt type is currently active and available.
     */
    @Column(
            name = "is_active",
            nullable = false,
            comment = "Flag indicating whether the debt type is active"
    )
    private Boolean isActive;

    /**
     * Name or identifier of the icon representing this debt type in the UI.
     */
    @Column(
            name = "icon_name",
            nullable = false,
            comment = "Identifier or filename of the icon associated with this debt type"
    )
    private String iconName;

}