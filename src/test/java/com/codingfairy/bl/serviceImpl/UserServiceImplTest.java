package com.codingfairy.bl.serviceImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.UserVo;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Mr.Zero on 2017/3/21.
 */
public class UserServiceImplTest extends BaseTest{

    @Resource
    private UserServiceImpl userService;

    @Test
    public void getUser() throws Exception {
        ResultVo<UserVo> resultVo = userService.getUser("cuiods");
        assertNotNull(resultVo);
    }

    @Test
    public void getUser1() throws Exception {
        ResultVo<UserVo> resultVo = userService.getUser(1);
        assertNotNull(resultVo);
    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void saveRoute() throws Exception {

    }

    @Test
    public void deleteRoute() throws Exception {

    }

    @Test
    public void follow() throws Exception {

    }

    @Test
    public void unfollow() throws Exception {

    }

}