package com.gemini.service;

import com.gemini.dao.UserDao;

/**
 * @author gemini
 * Created in  2021/5/3 22:07
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
