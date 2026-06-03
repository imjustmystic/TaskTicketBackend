package com.manognachamarthi.taskticket.taskticketbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manognachamarthi.taskticket.taskticketbackend.entity.Task;
import com.manognachamarthi.taskticket.taskticketbackend.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task deleteTask(Task task) {
        taskRepository.delete(task);
        return task;
    }
}