package com.codingfairy.bl.service;

import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.RouteVo;
import com.codingfairy.bl.vo.UserVo;

/**
 * Created by Mr.Zero on 2017/3/20.
 */

public interface UserService{

    ResultVo<UserVo> getUser(String username);

    ResultVo<UserVo> getUser(String username,String password);

    ResultVo<UserVo> getUser(int id);

    ResultVo<UserVo> saveUser(UserVo user);

    ResultVo<UserVo> updateUser(UserVo user);

    ResultVo<RouteVo> getRoutes(int userId);

    ResultVo<RouteVo> saveRoute(RouteVo route);

    void deleteRoute(int routeId);

    ResultVo<UserVo> follow(int userId,int followId);

    void unfollow(int userId,int followId);


}