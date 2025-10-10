package com.task.app.service;

import com.task.app.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    User createUser(User user);
    void deleteUser(Long id);
}
