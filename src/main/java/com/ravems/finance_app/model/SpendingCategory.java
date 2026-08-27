package com.ravems.finance_app.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity representing a spending category stored in the 'spending_categories' database table.
 */
@Entity
@Data
@Table(name = "spending_categories")
public class SpendingCategory {

    /**
     * Unique identifier for the spending category (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "spending_category_id",
            comment = "Unique primary key identifier for the spending category"
    )
    private Integer spendingCategoryId;

    /**
     * Name or label of the spending category (e.g., Groceries, Entertainment).
     */
    @Column(
            name = "name",
            nullable = false,
            comment = "Name or label of the spending category"
    )
    private String name;

    /**
     * Flag indicating whether the spending category is currently active and available.
     */
    @Column(
            name = "is_active",
            nullable = false,
            comment = "Flag indicating whether the spending category is active"
    )
    private Boolean isActive;

    /**
     * Name or identifier of the icon representing this spending category in the UI.
     */
    @Column(
            name = "icon_name",
            nullable = false,
            comment = "Identifier or filename of the icon associated with this spending category"
    )
    private String iconName;
}