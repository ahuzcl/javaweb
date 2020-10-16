package com.cunliang.test;

import com.cunliang.dao.UserDao;
import com.cunliang.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUserName() {
        UserDao userDao = new UserDaoImpl();
       // System.out.println(userDao.queryUserByUserName("admin"));
        if (userDao.queryUserByUserName("admin")==null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在，请重新输入");
        }


    }

    @Test
    public void saveUser() {
    }

    @Test
    public void queryUserByUserNameAndPassword() {
    }
}