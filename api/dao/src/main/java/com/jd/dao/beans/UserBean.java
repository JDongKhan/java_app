package com.jd.dao.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserBean implements Serializable {

    private static final long serialVersionUID = -2682305557890221059L;
    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_account;
    private String user_phone;
    private Integer user_flag;
    private Integer user_status;//0正常 1注销
    private String user_flag_string;
    private LocalDateTime last_login_time;

    public UserBean() {
        super();
    }

    public UserBean(Integer id, String username, String password, String account) {
        super();
        this.user_id = id;
        this.user_name = username;
        this.user_password = password;
        this.user_account = account;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Integer getUser_flag() {
        if (user_flag == null) {
            user_flag = 0;
        }
        return user_flag;
    }

    public void setUser_flag(Integer admin) {
        user_flag = admin;
        if (admin == 0) {
            this.user_flag_string = "员工";
        } else if (admin == 1) {
            this.user_flag_string = "管理员";
        } else if (admin == 2) {
            this.user_flag_string = "负责人";
        }
    }

    public String getUser_flag_string() {
        return user_flag_string;
    }

    public void setUser_flag_string(String user_flag_string) {
        this.user_flag_string = user_flag_string;
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    public LocalDateTime getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(LocalDateTime last_login_time) {
        this.last_login_time = last_login_time;
    }

    @Override
    public String toString() {
        return "UserBean [user_account=" + user_account + ", user_id=" + user_id + ", user_password="
                + user_password + ", user_name=" + user_name + " ,user_flag=" + user_flag +"]";
    }
}

