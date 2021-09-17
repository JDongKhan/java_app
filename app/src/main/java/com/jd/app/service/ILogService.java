package com.jd.app.service;



import com.jd.app.beans.LogBean;

import java.util.List;

public interface ILogService {

    public int insertLog(LogBean log) throws Exception;

    public List<LogBean> selectAllLog(String version) throws Exception;

}
