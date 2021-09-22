package com.jd.app.controller;

import com.jd.core.annotation.NotLogin;
import com.jd.dao.beans.Good;
import com.jd.app.service.IGoodsService;
import com.jd.core.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
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
    public Object queryGoodsByCategoryId(@NotNull Integer category_id) throws Exception {
        List<Good> list = goodsService.queryGoodsByCategoryId(category_id);
        return ResponseUtil.ok(list);
    }

}
