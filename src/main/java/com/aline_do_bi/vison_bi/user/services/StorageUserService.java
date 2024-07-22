package com.aline_do_bi.vison_bi.user.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aline_do_bi.vison_bi.user.domain.dtos.UserDTO;
import com.aline_do_bi.vison_bi.user.domain.entities.UserEntity;
import com.aline_do_bi.vison_bi.user.domain.useCases.StorageUserUseCase;
import com.aline_do_bi.vison_bi.user.repositories.UserRepository;

@Service
public class StorageUserService implements StorageUserUseCase {

    private final UserRepository userRepository;

    public StorageUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserEntity execute(UserDTO user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userRepository.save(userEntity);
    }
}
