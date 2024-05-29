package com.easyplanning.demo.persistence.repository;

import com.easyplanning.demo.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    public Usuario findByEmailAndClave(String email, String clave);
}
