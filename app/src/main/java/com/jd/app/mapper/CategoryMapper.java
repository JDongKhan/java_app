package com.jd.app.mapper;

import com.jd.app.beans.Category;

import java.util.List;

public interface CategoryMapper {

    List<Category> queryL1Category() throws Exception;

    List<Category> queryCategoryByPid(Integer pid) throws Exception;

}
