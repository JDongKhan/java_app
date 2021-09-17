package com.jd.app.service.impl;

import com.jd.app.beans.LogBean;
import com.jd.app.mapper.LogMapper;
import com.jd.app.service.ILogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements ILogService {

    @Resource
    private LogMapper um;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertLog(LogBean log) {
        return um.insertLog(log);
    }

    @Override
    public List<LogBean> selectAllLog(String version) {
        return um.selectAllLog(version);
    }
}
