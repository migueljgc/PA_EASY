package com.easyplanning.demo.domain.dto;


import com.easyplanning.demo.persistence.entity.Rol;
import com.easyplanning.demo.persistence.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {

    private Long id;

    private String descripcion;

}