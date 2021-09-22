package com.jd.dao.mapper;

import com.jd.dao.beans.Category;

import java.util.List;

public interface CategoryMapper {

    List<Category> queryL1Category() throws Exception;

    List<Category> queryCategoryByPid(Integer pid) throws Exception;

}
