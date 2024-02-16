package com.ddobii.back.ddobii.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddobii.back.ddobii.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 아이디 중복 검사
    Optional<User> findByUserId(String userId);

}
