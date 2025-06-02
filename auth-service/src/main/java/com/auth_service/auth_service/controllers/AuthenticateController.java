package com.auth_service.auth_service.controllers;

import com.auth_service.auth_service.config.JwtService;
import com.auth_service.auth_service.dto.ApiResponse;
import com.auth_service.auth_service.dto.AuthRequestDto;
import com.auth_service.auth_service.dto.JwtResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Authenticate Controller", description = "Operations about authenticate")
public class AuthenticateController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<JwtResponseDto>> authenticateAndGetToken(
            @RequestBody AuthRequestDto authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        System.out.println(authentication.getPrincipal());
        if (authentication.isAuthenticated()) {
            JwtResponseDto jwtResponse = JwtResponseDto.builder()
                    .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername()))
                    .build();

            ApiResponse<JwtResponseDto> response = new ApiResponse<>(
                    true,
                    "Login successfully",
                    jwtResponse);

            return ResponseEntity.ok(response);
        } else {
            throw new UsernameNotFoundException("Invalid user request..!!");
        }
    }
}

