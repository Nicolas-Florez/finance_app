package com.ravems.finance_app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Entity representing a system user stored in the 'users' database table.
 */
@Data
@Entity
@Table(name = "users")
public class User {

    /**
     * Unique identifier for the user (Primary Key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", comment = "Unique primary key identifier for the user record")
    private Long userId;

    /**
     * Unique email address used for authentication and communication.
     */
    @Column(
            name = "mail",
            nullable = false,
            unique = true,
            comment = "Unique email address used for login and notifications about debts"
    )
    private String mail;

    /**
     * Users encrypted password for authentication.
     */
    @Column(
            name = "password",
            nullable = false,
            comment = "Hashed password string for user authentication"
    )
    private String password;

    /**
     * Optional alias or handle displayed within the application.
     */
    @Column(name = "nickname", comment = "Optional display name or handle within the application")
    private String nickname;

    /**
     * Users primary given name.
     */
    @Column(
            name = "first_name",
            nullable = false,
            comment = "Users primary given name"
    )
    private String firstName;

    /**
     * Optional secondary given name.
     */
    @Column(name = "middle_name", comment = "Optional secondary given name")
    private String middleName;

    /**
     * Users primary surname/family name.
     */
    @Column(
            name = "last_name",
            nullable = false,
            comment = "Users primary surname or family name"
    )
    private String lastName;

    /**
     * Optional secondary surname/maternal family name.
     */
    @Column(name = "second_surname", comment = "Optional secondary surname or maternal family name")
    private String secondSurname;

    /**
     * Timestamp recording when the user record was initially created.
     */
    @CreationTimestamp
    @Column(
            name = "created_at",
            updatable = false,
            comment = "Timestamp recording when the user account was created"
    )
    private LocalDateTime createdAt;
}