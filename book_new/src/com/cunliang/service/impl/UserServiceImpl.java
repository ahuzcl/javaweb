package com.cunliang.service.impl;

import com.cunliang.dao.UserDao;
import com.cunliang.dao.impl.UserDaoImpl;
import com.cunliang.pojo.User;
import com.cunliang.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);

    }



    @Override
    public User login(User user) {

        return userDao.queryUserByUserNameAndPassword(user.getUsername(),user.getPassword());
    }

    /**
     *
     * @param username
     * @return 返回false可用
     */
    @Override
    public boolean existUser(String username) {

        if (userDao.queryUserByUserName(username) == null) {
            return false;
        }
        return true;
    }
}
