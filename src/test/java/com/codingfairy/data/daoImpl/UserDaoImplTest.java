package com.codingfairy.data.daoImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.util.enums.Gender;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * user dao test
 */
public class UserDaoImplTest extends BaseTest {

    @Resource
    private UserDao userDao;

    @Test
    public void findUserById() throws Exception {
        System.out.println(userDao.findUserById(1));
    }

    @Test
    public void findUserByName() throws Exception {
        System.out.println(userDao.findUserByName("cuiods"));
    }

    @Test
    public void findUserByNameAndPassword() throws Exception {
        Assert.assertTrue(userDao.findUserByNameAndPassword("cuiods","123456")!=null);
        Assert.assertTrue(userDao.findUserByNameAndPassword("cuiods","12345")==null);
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("testUser");
        userEntity.setPassword("123456");
        userEntity.setAvatar("http://hostel-world.oss-cn-shanghai.aliyuncs.com/images/avatar.png");
        userEntity.setPhone("11011001100");
        userEntity.setValid(1);
        userEntity.setGender(Gender.female);
        userEntity.setDescription("a test description");
        System.out.println("Create user id:" + userDao.save(userEntity).getId());
    }

}