package com.cunliang.service.impl;

import com.cunliang.pojo.User;
import com.cunliang.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {

        userService.registerUser(new User(null,"cunliang2","123","cunliang@uk.com"));
    }

    @Test
    public void login() {
    }

    @Test
    public void existUser() {
    }
}