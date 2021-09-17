package com.jd.app.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



public class LogBean implements Serializable {

    private static final long serialVersionUID = -2682305557890221052L;

    private Integer log_id;
    private String log_message;
    private String log_time;
    private String log_user_name;
    private String version;

    public LogBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public LogBean(Object object, String userName,String version) {
        this.log_message = object.toString();
        this.log_user_name = userName;
        this.version = version;
        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.log_time = ft.format(now);
    }

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public String getLog_message() {
        return log_message;
    }

    public void setLog_message(String log_message) {
        this.log_message = log_message;
    }

    public String getLog_time() {
        return log_time;
    }

    public void setLog_time(String log_time) {
        this.log_time = log_time;
    }

    public String getLog_user_name() {
        return log_user_name;
    }

    public void setLog_user_name(String log_user_name) {
        this.log_user_name = log_user_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
