package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.CommentDao;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.CommentEntity;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * comment dao
 */
public class CommentDaoImplTest extends BaseTest {

    @Resource
    private CommentDao commentDao;

    @Resource
    private UserDao userDao;

    @Resource
    private StoryDao storyDao;

    @Test
    public void findById() throws Exception {
        System.out.println(commentDao.findById(1));
    }

    @Test
    @Rollback
    @Transactional
    public void save() throws Exception {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setUserEntity(userDao.findUserById(1));
        commentEntity.setStoryEntity(storyDao.findById(1));
        commentEntity.setContent("照片真好看！笑得好开心！");
        System.out.println(commentDao.save(commentEntity).getId());
    }

    @Test
    public void delete() throws Exception {

    }

}