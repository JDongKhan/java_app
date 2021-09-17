package com.jd.app.beans;

public class Version {
    private  int version_id;
    private  String version_name;
    private  int version_status;
    private  String version_status_string;
    private  String version_charge;
    private  int version_creater;
    private  int version_type;

    public int getVersion_id() {
        return version_id;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public int getVersion_status() {
        return version_status;
    }

    public void setVersion_status(int version_status) {
        this.version_status = version_status;
        if (version_status == 0) {
            this.version_status_string = "未发布";
        } else if (version_status == 1) {
            this.version_status_string = "已发布";
        }
    }

    public String getVersion_status_string() {
        return version_status_string;
    }

    public void setVersion_status_string(String version_status_string) {
        this.version_status_string = version_status_string;
    }

    public String getVersion_charge() {
        return version_charge;
    }

    public void setVersion_charge(String version_charge) {
        this.version_charge = version_charge;
    }

    public int getVersion_creater() {
        return version_creater;
    }

    public void setVersion_creater(int version_creater) {
        this.version_creater = version_creater;
    }

    public int getVersion_type() {
        return version_type;
    }

    public void setVersion_type(int version_type) {
        this.version_type = version_type;
    }
}
