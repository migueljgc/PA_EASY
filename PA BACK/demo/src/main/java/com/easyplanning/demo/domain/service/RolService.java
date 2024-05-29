package com.easyplanning.demo.domain.service;


import com.easyplanning.demo.domain.dto.RolDTO;
import com.easyplanning.demo.domain.mapper.RolMapper;

import com.easyplanning.demo.persistence.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RolService {
    @Autowired
    private final RolRepository rolRepository;

    public RolDTO save(RolDTO rolDTO) {
        rolRepository.save(RolMapper.toEntity(rolDTO));
        return rolDTO;
    }

    public List<RolDTO> getAll() {
        return rolRepository.findAll().stream().map(RolMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<RolDTO> findById(Long id) {
        return rolRepository.findById(id).map(RolMapper::toDTO);
    }
}