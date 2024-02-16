package com.ddobii.back.ddobii.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddobii.back.ddobii.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 이미 가입된 아이디인지 확인
    Optional<User> findByUserId(String userId);

}
