package com.codingfairy.data.dao;

import com.codingfairy.data.entity.RouteStoryEntity;
import com.codingfairy.data.entity.RouteStoryEntityPK;

/**
 * Created by cuihao on 2017/3/21.
 */
public interface RouteStoryDao {
    RouteStoryEntity findById(RouteStoryEntityPK routeStoryEntityPK);
    RouteStoryEntity save(RouteStoryEntity routeStoryEntity);
    void delete(RouteStoryEntityPK routeStoryEntityPK);
}
