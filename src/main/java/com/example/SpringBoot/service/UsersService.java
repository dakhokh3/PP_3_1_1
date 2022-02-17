package com.example.SpringBoot.service;

import com.example.SpringBoot.entity.User;

import java.util.List;

public interface UsersService {

    List<User> allUsers();
    void add(User user);
    void delete(int id);
    void edit(User user);
    User getById(int id);
}