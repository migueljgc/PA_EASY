package com.easyplanning.demo.domain.mapper;


import com.easyplanning.demo.domain.dto.RolDTO;
import com.easyplanning.demo.persistence.entity.Rol;

public class RolMapper {
    public static Rol toEntity(RolDTO roldto) {
        Rol rol = new Rol();
        rol.setId(roldto.getId());
        rol.setDescripcion(roldto.getDescripcion());
        return rol;
    }

    public static RolDTO toDTO(Rol rol) {
        RolDTO roldto = new RolDTO();
        roldto.setId(rol.getId());
        roldto.setDescripcion(rol.getDescripcion());
        return roldto;
    }
}
