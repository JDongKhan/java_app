package com.jd.app.service;

import com.jd.dao.beans.Recommend;

import java.util.List;

public interface IRecommendService {

    List<Recommend>  queryRecommend(Integer user_id) throws Exception;

}
