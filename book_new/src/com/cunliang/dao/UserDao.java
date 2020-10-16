package com.cunliang.dao;

import com.cunliang.pojo.User;

public interface UserDao {

    /**
     *
     * @param username
     * @return 如果返回null，说明数据库中没有此用户。
     */
    public User queryUserByUserName(String username);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUserNameAndPassword(String username,String password);




}
