package com.easyplanning.demo.persistence.entity;

import com.easyplanning.demo.domain.dto.RolDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Column(name = "Email")
    @Id
    private String email;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Documento")
    private String documento;



    @Column(name = "Clave")
    private String clave;

    @JoinColumn(name = "Rol_id")
    @ManyToOne
    private Rol rol;


}
