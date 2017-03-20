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

    ResultVo<RouteVo> saveRoute(int userId, List<Integer> storyIdList);

    ResultVo<Void> deleteRoute(int routeId);

    ResultVo<UserVo> follow(int userId,int followId);

    ResultVo<Void> unfollow(int userId,int followId);


}