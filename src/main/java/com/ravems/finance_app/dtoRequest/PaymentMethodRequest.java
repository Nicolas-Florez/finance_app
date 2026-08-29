package com.ravems.finance_app.dtoRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaymentMethodRequest {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre  no puede tner mas de 50 caracteres")
    private String name;

    @NotBlank (message = "El estado es obligatorio")
    private Boolean isActive;
    private String iconName;
}
