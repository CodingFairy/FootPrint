package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.RouteDao;
import com.codingfairy.data.entity.RouteEntity;
import com.codingfairy.data.repository.RouteRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class RouteDaoImpl implements RouteDao {

    @Resource
    private RouteRepository routeRepository;

    @Override
    public RouteEntity save(RouteEntity routeEntity) {
        return routeRepository.save(routeEntity);
    }

    @Override
    public RouteEntity findById(int id) {
        return routeRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        routeRepository.delete(id);
    }
}
