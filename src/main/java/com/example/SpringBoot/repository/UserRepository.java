package com.example.SpringBoot.repository;


import com.example.SpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}