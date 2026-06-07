package com.manognachamarthi.taskticket.taskticketbackend.service;

import java.util.List;

import org.springframework.lang.NonNull;
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

    public List<Task> getTasksForUser(@NonNull Long userId) {
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return user.getTasks();
    }

    public Task getSpecificTaskForUser(@NonNull Long userId, @NonNull Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        if (!task.getUser().getId().equals(userId)) {
            throw new RuntimeException("Task does not belong to user with id: " + userId);
        }
        return task;
    }

    public Task createTask(@NonNull Long userId, Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void deleteById(Long userId, @NonNull Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        if (!task.getUser().getId().equals(userId)) {
            throw new RuntimeException("Task does not belong to user with id: " + userId);
        }
        taskRepository.deleteById(taskId);
    }

}