package com.naukari.noukari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naukari.noukari.entity.UserEntity;
import com.naukari.noukari.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	UserEntity findByUserId(String userName);

}
