package com.ravems.finance_app.dtoResponse;

import lombok.Data;

@Data
public class DebtTypeResponse {
    private Integer id;
    private String name;
    private Boolean isActive;
    private String iconName;
}
