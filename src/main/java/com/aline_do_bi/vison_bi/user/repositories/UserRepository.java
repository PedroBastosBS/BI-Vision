package com.aline_do_bi.vison_bi.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aline_do_bi.vison_bi.user.domain.entities.UserEntity;

public interface  UserRepository extends JpaRepository<UserEntity, UUID>{
}
