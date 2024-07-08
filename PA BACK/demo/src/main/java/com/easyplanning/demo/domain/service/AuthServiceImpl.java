package com.easyplanning.demo.domain.service;

import com.easyplanning.demo.api.controller.models.AuthResponse;
import com.easyplanning.demo.api.controller.models.AuthenticationRequest;
import com.easyplanning.demo.api.controller.models.RegisterRequest;
import com.easyplanning.demo.persistence.entity.Rol;
import com.easyplanning.demo.persistence.entity.Usuario;
import com.easyplanning.demo.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UsuarioRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .clave(passwordEncoder.encode(request.getClave()))
                .telefono(request.getTelefono())
                .rol(Rol.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.genereteToken((UserDetails) user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getClave()
                )
        );
        UserDetails user = userRepository.findEmailByEmail(request.getEmail()).orElseThrow();
        String jwtToken = jwtService.genereteToken(user);
        List<String> roles = user.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        return AuthResponse.builder()
                .token(jwtToken)
                .authorities(roles)
                .build();
    }
    @Override
    public Usuario getCurrentUser(Authentication authentication) {
        return (Usuario) authentication.getPrincipal();
    }

}