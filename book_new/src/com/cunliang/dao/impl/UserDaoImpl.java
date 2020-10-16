package com.cunliang.dao.impl;

import com.cunliang.dao.UserDao;
import com.cunliang.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUserName(String username) {


        return null;
    }

    @Override
    public int saveUser(User user) {
        return 0;
    }

    @Override
    public User queryUserByUserNameAndPassword(String username, String password) {
        return null;
    }
}
