package com.codingfairy.data.dao;

import com.codingfairy.data.entity.RouteStoryEntity;

/**
 * route story dao
 */
public interface RouteStoryDao {
    RouteStoryEntity findById(int id);
    RouteStoryEntity save(RouteStoryEntity routeStoryEntity);
    void delete(int id);
}
