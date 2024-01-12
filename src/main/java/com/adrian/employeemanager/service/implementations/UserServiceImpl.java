package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.model.User;
import com.adrian.employeemanager.repository.UserRepository;
import com.adrian.employeemanager.service.interfaces.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found."));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found."));

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setModified(user.getModified());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException("User with id: " + id + " not found.");
        }
        userRepository.deleteById(id);
    }
}
