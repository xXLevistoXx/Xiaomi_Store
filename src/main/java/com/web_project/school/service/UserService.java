package com.web_project.school.service;

import com.web_project.school.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public List<UserModel> findAllUsers();

    public UserModel findUserById(UUID id);

    public UserModel addUser(UserModel user);

    public UserModel updateUser(UserModel user);

    public void deleteUser(UUID id);
}