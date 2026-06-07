package com.manognachamarthi.taskticket.taskticketbackend.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.manognachamarthi.taskticket.taskticketbackend.entity.User;
import com.manognachamarthi.taskticket.taskticketbackend.repository.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(@NonNull Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User createUser(@NonNull User user) {
        return userRepository.save(user);
    }

    public void deleteById(@NonNull Long id) {
        userRepository.deleteById(id);
    }

}
