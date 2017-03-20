package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.UserService;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.RouteVo;
import com.codingfairy.bl.vo.UserVo;
import com.codingfairy.util.enums.Gender;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cuihao on 2017/3/20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResultVo<UserVo> getUser(String username) {
        return null;
    }

    @Override
    public ResultVo<UserVo> getUser(int id) {
        return null;
    }

    @Override
    public ResultVo<UserVo> updateUser(int id, String avatar, Gender gender, String description) {
        return null;
    }

    @Override
    public ResultVo<RouteVo> saveRoute(int userId, List<Integer> storyIdList) {
        return null;
    }

    @Override
    public ResultVo<Void> deleteRoute(int routeId) {
        return null;
    }

    @Override
    public ResultVo<UserVo> follow(int userId, int followId) {
        return null;
    }

    @Override
    public ResultVo<Void> unfollow(int userId, int followId) {
        return null;
    }
}
