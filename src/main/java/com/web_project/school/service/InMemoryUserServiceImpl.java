package com.web_project.school.service;

import com.web_project.school.model.UserModel;
import com.web_project.school.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryUserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public InMemoryUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAllUsers() {
        return userRepository.findAll(Sort.by("id"));
    }

    @Override
    public UserModel findUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}