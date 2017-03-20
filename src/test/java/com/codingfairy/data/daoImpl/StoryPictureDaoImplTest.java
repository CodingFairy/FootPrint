package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.dao.StoryPictureDao;
import com.codingfairy.data.entity.StoryEntity;
import com.codingfairy.data.entity.StoryPicEntity;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * story pic dao impl test
 * @author cuihao
 */
public class StoryPictureDaoImplTest extends BaseTest {

    @Resource
    private StoryPictureDao storyPictureDao;

    @Resource
    private StoryDao storyDao;

    @Test
    @Rollback
    @Transactional
    public void save() throws Exception {
        StoryEntity storyEntity = storyDao.findById(1);
        StoryPicEntity storyPicEntity = new StoryPicEntity();
        storyPicEntity.setUrl("http://hostel-world.oss-cn-shanghai.aliyuncs.com/images/logo.png");
        storyPicEntity.setStoryEntity(storyEntity);
        System.out.println(storyPictureDao.save(storyPicEntity).getId());
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findById() throws Exception {
        System.out.println(storyDao.findById(1));
    }

}