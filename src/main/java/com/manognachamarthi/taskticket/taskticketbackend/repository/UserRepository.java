package com.manognachamarthi.taskticket.taskticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manognachamarthi.taskticket.taskticketbackend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
