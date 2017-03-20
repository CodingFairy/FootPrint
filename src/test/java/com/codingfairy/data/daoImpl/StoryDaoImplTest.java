package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.StoryEntity;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * story test
 */
public class StoryDaoImplTest extends BaseTest {

    @Resource
    private StoryDao storyDao;

    @Resource
    private UserDao userDao;

    @Test
    @Transactional
    public void findById() throws Exception {
        System.out.println(storyDao.findById(1).getContent());
        System.out.println(storyDao.findById(1).getPicEntities().size());
    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        StoryEntity storyEntity = new StoryEntity();
        storyEntity.setContent("今天也好开心呀!");
        storyEntity.setLongitude(118.78);
        storyEntity.setLatitude(32.04);
        storyEntity.setAuthor(userDao.findUserById(1));
        storyEntity.setAnger(0.00019452213);
        storyEntity.setContempt(0.000333736039);
        storyEntity.setDisgust(0.000693641952);
        storyEntity.setFear(0.00000172743637);
        storyEntity.setHappiness(0.9509745);
        storyEntity.setNeutral(0.04753512);
        storyEntity.setSadness(0.000177138063);
        storyEntity.setSurprise(0.00008960857);
        System.out.println(storyDao.save(storyEntity).getId());
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findByLocation() throws Exception {
        System.out.println(storyDao.findByLocation(118.78,32.04,10));
    }

}