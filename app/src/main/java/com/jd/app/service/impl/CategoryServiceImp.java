package com.jd.app.service.impl;

import com.jd.app.beans.Category;
import com.jd.app.mapper.CategoryMapper;
import com.jd.app.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImp implements ICategoryService {

    @Resource
    private CategoryMapper um;


    @Override
    public List<Category> queryL1Category() throws Exception {
        return um.queryL1Category();
    }

    @Override
    public List<Category> queryCategoryByPid(Integer pid) throws Exception {
        return um.queryCategoryByPid(pid);
    }
}
