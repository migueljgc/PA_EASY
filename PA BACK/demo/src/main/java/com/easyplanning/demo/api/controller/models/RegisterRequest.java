package com.easyplanning.demo.api.controller.models;

import com.easyplanning.demo.persistence.entity.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nombre;
    private String apellido;
    private String telefono;
    private String documento;
    private String email;
    private String clave;
    private Rol rol;

}
