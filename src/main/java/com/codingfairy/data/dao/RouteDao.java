package com.codingfairy.data.dao;

import com.codingfairy.data.entity.RouteEntity;

/**
 * Created by cuihao on 2017/3/20.
 */
public interface RouteDao {
    RouteEntity save(RouteEntity routeEntity);
    RouteEntity findById(int id);
    void delete(int id);
}
