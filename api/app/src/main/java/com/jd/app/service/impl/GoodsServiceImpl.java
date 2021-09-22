package com.jd.app.service.impl;

import com.jd.dao.beans.Good;
import com.jd.dao.mapper.GoodsMapper;
import com.jd.app.service.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Resource
    private GoodsMapper mapper;


    @Override
    public List<Good> queryGoodsByCategoryId(Integer category_id) throws Exception {
        return mapper.queryGoodsByCategoryId(category_id);
    }
}
