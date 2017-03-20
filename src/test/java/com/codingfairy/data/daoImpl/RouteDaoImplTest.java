package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.RouteDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.RouteEntity;
import com.codingfairy.data.entity.RouteStoryEntity;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017/3/21.
 */
public class RouteDaoImplTest extends BaseTest {

    @Resource
    private RouteDao routeDao;

    @Resource
    private UserDao userDao;

    @Test
    @Rollback
    @Transactional
    public void save() throws Exception {
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setDescription("黄山之旅");
        routeEntity.setUserEntity(userDao.findUserById(1));
        System.out.println(routeDao.save(routeEntity).getId());
    }

    @Test
    public void findById() throws Exception {
        System.out.println(routeDao.findById(1));
    }

    @Test
    public void delete() throws Exception {

    }

}