package com.jd.dao.mapper;

import com.jd.dao.beans.Recommend;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecommendMapper {


    @Select("select * from t_recommend where user_id=#{user_id} ")
    @Results({
            @Result(property = "good",column = "good_id",one = @One(select = "com.jd.dao.mapper.GoodsMapper.queryGoodById"))
    })
    public List<Recommend> queryList(Integer user_id) throws Exception;

}
