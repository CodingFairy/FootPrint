package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.RouteDao;
import com.codingfairy.data.entity.RouteEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class RouteDaoImpl implements RouteDao {
    @Override
    public RouteEntity save(RouteEntity routeEntity) {
        return null;
    }

    @Override
    public RouteEntity findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
