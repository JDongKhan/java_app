package com.jd.app.service.impl;

import javax.annotation.Resource;

import com.jd.dao.beans.UserBean;
import com.jd.dao.mapper.UserMapper;
import com.jd.app.service.IUserService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper um;


    public UserBean login(String userAccount, String password)throws Exception {
        return um.login(userAccount, password);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int registerAccount(UserBean userBean) throws Exception {
        return um.insertUser(userBean);
    }

    @Override
    public int updateUser(UserBean userBean) throws Exception {
        return um.updateUser(userBean);
    }

    @Override
    public UserBean queryUserByAccount(String userAccount) throws Exception {
        return um.queryByAccount(userAccount);
    }

    @Override
    public UserBean queryUserByID(int user_id) throws Exception {
        return um.queryUserById(user_id);
    }

    @Override
    public List<UserBean> queryAllUser() throws Exception {
        return um.queryAllUser();
    }

    @Override
    public int deleteUser(int user_id) throws Exception {
        return um.deleteUser(user_id);
    }


}
