package com.jd.app.service.impl;

import javax.annotation.Resource;

import com.jd.dao.beans.User;
import com.jd.dao.mapper.UserMapper;
import com.jd.app.service.IUserService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper mapper;


    public User login(String userAccount, String password)throws Exception {
        return mapper.login(userAccount, password);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int registerAccount(User user) throws Exception {
        return mapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return mapper.updateUser(user);
    }

    @Override
    public User queryUserByAccount(String userAccount) throws Exception {
        return mapper.queryByAccount(userAccount);
    }

    @Override
    public User queryUserByID(int user_id) throws Exception {
        return mapper.queryUserById(user_id);
    }

    @Override
    public List<User> queryAllUser() throws Exception {
        return mapper.queryAllUser();
    }

    @Override
    public int deleteUser(int user_id) throws Exception {
        return mapper.deleteUser(user_id);
    }


}
