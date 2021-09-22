package com.jd.app.controller;


import com.jd.core.annotation.NotLogin;
import com.jd.dao.beans.Category;
import com.jd.app.service.ICategoryService;
import com.jd.core.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
@Slf4j
@Validated
public class CategoryController {


    @Resource
    private ICategoryService categoryService;

    @GetMapping("/list")
    @NotLogin
    public Object list() throws Exception {
      List<Category> list =  categoryService.queryL1Category();
      for (Category item : list) {
            List<Category> subItem = categoryService.queryCategoryByPid(item.getId());
            item.setSubCategory(subItem);
      }
      return ResponseUtil.ok(list);
    }

}
