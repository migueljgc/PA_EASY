package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.common.routes;
import com.easyplanning.demo.domain.dto.PaqueteDTO;
import com.easyplanning.demo.domain.dto.RolDTO;
import com.easyplanning.demo.persistence.entity.Rol;
import com.easyplanning.demo.domain.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = routes.API + routes.Rol.ROL)

public class RolController {
    @Autowired
    private  RolService rolService;

    @PostMapping(value = routes.Rol.SAVE_ROL)
    public RolDTO save(@RequestBody RolDTO rolDTO){
        return rolService.save(rolDTO);
    }

    @GetMapping(value = routes.Rol.GET_ROL)
    public List<RolDTO> get(){return rolService.getAll();}

    @PutMapping(value =routes.Rol.UPDATE_ROL)
    public ResponseEntity<?> update(@RequestBody RolDTO rolDTO) {
        Optional<RolDTO> rolDTOOptional = rolService.findById(rolDTO.getId());
        if(rolDTOOptional.isPresent()) {
            rolService.save(rolDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}