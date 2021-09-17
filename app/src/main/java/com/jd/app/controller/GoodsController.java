package com.jd.app.controller;

import com.jd.app.annotation.NotLogin;
import com.jd.app.beans.Good;
import com.jd.app.service.IGoodsService;
import com.jd.app.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/goods")
@Slf4j
@Validated
public class GoodsController {

    @Resource
    private IGoodsService goodsService;



    @GetMapping("/listByCategoryId")
    @NotLogin
    public Object queryGoodsByCategoryId(Integer category_id) throws Exception {
        List<Good> list = goodsService.queryGoodsByCategoryId(category_id);
        return ResponseUtil.ok(list);
    }

}
