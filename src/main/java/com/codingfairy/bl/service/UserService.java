package com.codingfairy.bl.service;

import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.RouteVo;
import com.codingfairy.bl.vo.UserVo;
import com.codingfairy.util.enums.Gender;

import java.util.List;

/**
 * Created by Mr.Zero on 2017/3/20.
 */

public interface UserService{

    ResultVo<UserVo> getUser(String username);

    ResultVo<UserVo> getUser(int id);

    ResultVo<UserVo> updateUser(int id, String avatar,Gender gender,String description);

    /**
     * 默认路线中点的顺序就是传入的list中点的顺序
     */
    ResultVo<RouteVo> saveRoute(int userId, List<Integer> storyIdList, String description);

    ResultVo<Void> deleteRoute(int routeId);

    ResultVo<Boolean> follow(int userId,int followId);

    ResultVo<Void> unfollow(int id);


}