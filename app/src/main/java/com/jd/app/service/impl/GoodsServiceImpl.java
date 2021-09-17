package com.jd.app.service.impl;

import com.jd.app.beans.Good;
import com.jd.app.mapper.GoodsMapper;
import com.jd.app.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Resource
    private GoodsMapper um;


    @Override
    public List<Good> queryGoodsByCategoryId(Integer category_id) throws Exception {
        return um.queryGoodsByCategoryId(category_id);
    }
}
