package com.manognachamarthi.taskticket.taskticketbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manognachamarthi.taskticket.taskticketbackend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
