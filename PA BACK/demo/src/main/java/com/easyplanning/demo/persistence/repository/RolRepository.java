package com.easyplanning.demo.persistence.repository;

import com.easyplanning.demo.persistence.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
