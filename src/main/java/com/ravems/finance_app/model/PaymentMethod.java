package com.ravems.finance_app.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity representing a payment method stored in the 'payment_methods' database table.
 */
@Entity
@Data
@Table(name = "payment_methods")
public class PaymentMethod {

    /**
     * Unique identifier for the payment method (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "payment_method_id",
            comment = "Unique primary key identifier for the payment method"
    )
    private Integer paymentMethodId;

    /**
     * Name or label of the payment method (e.g., Credit Card, Cash, Bank Transfer).
     */
    @Column(
            name = "name",
            nullable = false,
            comment = "Name or label of the payment method"
    )
    private String name;

    /**
     * Flag indicating whether the payment method is currently active and available.
     */
    @Column(
            name = "is_active",
            nullable = false,
            comment = "Flag indicating whether the payment method is active"
    )
    private Boolean isActive;

    /**
     * Name or identifier of the icon representing this payment method in the UI.
     */
    @Column(
            name = "icon_name",
            nullable = false,
            comment = "Identifier or filename of the icon associated with this payment method"
    )
    private String iconName;
}