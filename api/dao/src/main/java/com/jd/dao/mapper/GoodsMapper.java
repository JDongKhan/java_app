package com.jd.dao.mapper;

import com.jd.dao.beans.Good;

import java.util.List;


public interface GoodsMapper {

    List<Good> queryGoodsByCategoryId(Integer category_id) throws Exception;

    Good queryGoodById(Integer id) throws Exception;

}
