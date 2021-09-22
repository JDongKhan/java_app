package com.jd.app.service;


import com.jd.dao.beans.UserBean;

import java.util.List;

public interface IUserService {

    public UserBean login(String userAccount, String password) throws Exception;

    public int registerAccount(UserBean userBean) throws Exception;

    public int updateUser(UserBean userBean) throws Exception;

    public UserBean queryUserByAccount(String userAccount) throws Exception;

    public UserBean queryUserByID(int user_id) throws Exception;

    public List<UserBean> queryAllUser() throws Exception;

    public int deleteUser(int user_id) throws Exception;

}
