package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.RouteStoryDao;
import com.codingfairy.data.entity.RouteStoryEntity;
import com.codingfairy.data.repository.RouteStoryRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017/3/21.
 */
@Repository
public class RouteStoryDaoImpl implements RouteStoryDao {

    @Resource
    private RouteStoryRepository routeStoryRepository;

    @Override
    public RouteStoryEntity findById(int id) {
        return routeStoryRepository.findOne(id);
    }

    @Override
    public RouteStoryEntity save(RouteStoryEntity routeStoryEntity) {
        return routeStoryRepository.save(routeStoryEntity);
    }

    @Override
    public void delete(int id) {
        routeStoryRepository.delete(id);
    }
}
