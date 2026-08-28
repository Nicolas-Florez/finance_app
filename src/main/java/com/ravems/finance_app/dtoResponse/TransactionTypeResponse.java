package com.ravems.finance_app.dtoResponse;

import lombok.Data;

@Data
public class TransactionTypeResponse {
    private Integer id;
    private String name;
    private Boolean isActive;
    private String iconName;
}
