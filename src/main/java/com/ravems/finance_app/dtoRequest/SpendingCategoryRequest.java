package com.ravems.finance_app.dtoRequest;

import lombok.Data;

@Data
public class SpendingCategoryRequest{

    private String name;
    private Boolean isActive;
    private String iconName;
}
