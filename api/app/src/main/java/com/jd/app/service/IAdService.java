package com.jd.app.service;

import com.jd.dao.beans.Ad;

import java.util.List;

public interface IAdService {
    List<Ad> queryAdList() throws  Exception;
}
