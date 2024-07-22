package com.aline_do_bi.vison_bi.user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aline_do_bi.vison_bi.user.domain.dtos.UserDTO;
import com.aline_do_bi.vison_bi.user.domain.entities.UserEntity;
import com.aline_do_bi.vison_bi.user.domain.useCases.StorageUserUseCase;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    private final StorageUserUseCase storageUserUseCase;

    public UserController(StorageUserUseCase storageUserUseCase) {
        this.storageUserUseCase = storageUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserEntity> postMethodName(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(storageUserUseCase.execute(user));
    }
    
}
