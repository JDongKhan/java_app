package com.jd.app.mapper;

import com.jd.app.beans.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface GoodsMapper {

    List<Good> queryGoodsByCategoryId(Integer category_id) throws Exception;

}
