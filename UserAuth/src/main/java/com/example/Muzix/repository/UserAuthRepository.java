package com.example.Muzix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.model.User;

@Repository
public interface UserAuthRepository extends JpaRepository<User, String> {