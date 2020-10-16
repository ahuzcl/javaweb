package com.cunliang.service;

import com.cunliang.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 用户登陆
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查是否存在用户
     * @param username
     * @return
     */
    public boolean existUser(String username);






}
