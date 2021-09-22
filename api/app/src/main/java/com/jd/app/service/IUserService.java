package com.jd.app.service;


import com.jd.dao.beans.User;

import java.util.List;

public interface IUserService {

    public User login(String userAccount, String password) throws Exception;

    public int registerAccount(User user) throws Exception;

    public int updateUser(User user) throws Exception;

    public User queryUserByAccount(String userAccount) throws Exception;

    public User queryUserByID(int user_id) throws Exception;

    public List<User> queryAllUser() throws Exception;

    public int deleteUser(int user_id) throws Exception;

}
