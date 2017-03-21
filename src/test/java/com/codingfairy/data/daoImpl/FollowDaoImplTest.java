package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.FollowDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.UserFollowEntity;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017/3/21.
 */
public class FollowDaoImplTest extends BaseTest {

    @Resource
    private UserDao userDao;

    @Resource
    private FollowDao followDao;

    @Test
    public void save() throws Exception {
        UserFollowEntity userFollowEntity = new UserFollowEntity();
        userFollowEntity.setUserId(1);
        userFollowEntity.setFollowId(3);
        System.out.println(followDao.save(userFollowEntity).getId());
    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}