package com.jd.app.service;


import com.jd.app.beans.Good;

import java.util.List;

public interface IGoodsService {

    List<Good> queryGoodsByCategoryId(Integer category_id) throws Exception;

}
