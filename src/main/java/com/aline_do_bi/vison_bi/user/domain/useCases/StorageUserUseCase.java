package com.aline_do_bi.vison_bi.user.domain.useCases;

import com.aline_do_bi.vison_bi.user.domain.dtos.UserDTO;
import com.aline_do_bi.vison_bi.user.domain.entities.UserEntity;

public interface  StorageUserUseCase {
    UserEntity execute(UserDTO user);
}
