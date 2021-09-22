package com.jd.app.service.impl;

import com.jd.app.service.IRecommendService;
import com.jd.dao.beans.Recommend;
import com.jd.dao.mapper.RecommendMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecommendServiceImp implements IRecommendService {
    @Resource
    RecommendMapper mapper;

    @Override
    public List<Recommend> queryRecommend(Integer user_id)  throws Exception {
        return mapper.queryList(user_id);
    }
}
