package com.jd.app.service;

import com.jd.dao.beans.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> queryL1Category() throws Exception;

    List<Category> queryCategoryByPid(Integer pid) throws Exception;

}
