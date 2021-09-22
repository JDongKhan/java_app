package com.jd.app.service.impl;

import com.jd.app.service.IAdService;
import com.jd.dao.beans.Ad;
import com.jd.dao.mapper.AdMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdServiceImp implements IAdService {

    @Resource
    AdMapper mapper;

    @Override
    public List<Ad> queryAdList() throws Exception {
        return mapper.queryAdList();
    }
}
