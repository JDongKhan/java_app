package com.jd.dao.mapper;

import com.jd.dao.beans.Ad;

import java.util.List;

public interface AdMapper {

    List<Ad> queryAdList() throws  Exception;

}
