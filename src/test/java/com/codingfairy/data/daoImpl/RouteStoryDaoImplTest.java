package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.RouteDao;
import com.codingfairy.data.dao.RouteStoryDao;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.entity.RouteStoryEntity;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017/3/21.
 */
public class RouteStoryDaoImplTest extends BaseTest {

    @Resource
    private RouteStoryDao routeStoryDao;

    @Resource
    private StoryDao storyDao;

    @Resource
    private RouteDao routeDao;


    @Test
    public void findById() throws Exception {
        System.out.println(routeStoryDao.findById(1));
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        RouteStoryEntity routeStoryEntity = new RouteStoryEntity();
        routeStoryEntity.setRouteEntity(routeDao.findById(1));
        routeStoryEntity.setStoryEntity(storyDao.findById(1));
        routeStoryEntity.setNum(1);
        System.out.println(routeStoryDao.save(routeStoryEntity).getId());
    }

    @Test
    public void delete() throws Exception {

    }

}