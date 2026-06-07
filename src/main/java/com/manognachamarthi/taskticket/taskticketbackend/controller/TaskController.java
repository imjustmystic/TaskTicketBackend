package com.manognachamarthi.taskticket.taskticketbackend.controller;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manognachamarthi.taskticket.taskticketbackend.entity.Task;
import com.manognachamarthi.taskticket.taskticketbackend.service.TaskService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/users")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("{userId}/tasks")
    public List<Task> getTaskForUser(@NonNull @PathVariable Long userId){
        return taskService.getTasksForUser(userId);
    }

    @GetMapping("{userId}/tasks/{taskId}")
    public Task getTaskById(@NonNull @PathVariable Long userId, @NonNull @PathVariable Long taskId) {
        return taskService.getSpecificTaskForUser(userId, taskId);
    }
    
    
    
    @PostMapping("/{userId}/tasks")
    public Task createTask(@NonNull @PathVariable Long userId,@Valid @RequestBody Task task) {
        return taskService.createTask(userId, task);
    }

    @DeleteMapping("/{userId}/tasks/{taskId}")
    public void deleteTask(@NonNull @PathVariable Long userId,@NonNull @PathVariable Long taskId) {
        taskService.deleteById(userId, taskId);
    }
}
