package com.codingfairy.bl.serviceImpl;

import com.codingfairy.BaseTest;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.RouteVo;
import com.codingfairy.bl.vo.UserVo;
import com.codingfairy.util.enums.Gender;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

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
        ResultVo<UserVo> resultVo = userService.updateUser(5,"http://hostel-world.oss-cn-shanghai.aliyuncs.com/images/avatar.png", Gender.female,"这是测试用户的description");
        assertNotNull(resultVo);
    }

    @Test
    public void saveRoute() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ResultVo<RouteVo> resultVo = userService.saveRoute(1,list,"route description");
        assertNotNull(resultVo);
    }

    @Test
    public void deleteRoute() throws Exception {

    }

    @Test
    public void follow() throws Exception {
//        assertNotNull(userService.follow(5,1));
    }

    @Test
    public void unfollow() throws Exception {
//        assertNotNull(userService.unfollow(2));
    }

}