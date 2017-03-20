package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.StarDao;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.StarEntity;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by cuihao on 2017/3/20.
 */
public class StarDaoImplTest extends BaseTest {

    @Resource
    private StarDao starDao;

    @Resource
    private StoryDao storyDao;

    @Resource
    private UserDao userDao;

    @Test
    @Rollback
    @Transactional
    public void save() throws Exception {
        StarEntity starEntity = new StarEntity();
        starEntity.setStoryEntity(storyDao.findById(1));
        starEntity.setUserEntity(userDao.findUserById(1));
        System.out.println(starDao.save(starEntity).getId());
    }

    @Test
    public void findById() throws Exception {
        System.out.println(starDao.findById(1));
    }

    @Test
    public void delete() throws Exception {

    }

}