package com.manognachamarthi.taskticket.taskticketbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manognachamarthi.taskticket.taskticketbackend.entity.Task;
import com.manognachamarthi.taskticket.taskticketbackend.entity.User;
import com.manognachamarthi.taskticket.taskticketbackend.repository.TaskRepository;
import com.manognachamarthi.taskticket.taskticketbackend.repository.UserRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Long userId, Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        task.setUser(user);
        return taskRepository.save(task);
    }

}