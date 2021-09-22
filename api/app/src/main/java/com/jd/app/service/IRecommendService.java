package com.jd.app.service;

import com.jd.dao.beans.Recommend;

import java.util.List;

public interface IRecommendService {

    List<Recommend>  queryRecommendList(Integer user_id) throws Exception;

}
