package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.UserService;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.RouteVo;
import com.codingfairy.bl.vo.UserVo;
import com.codingfairy.data.dao.RouteDao;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.RouteEntity;
import com.codingfairy.data.entity.RouteStoryEntity;
import com.codingfairy.data.entity.StoryEntity;
import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.util.constant.ErrorCode;
import com.codingfairy.util.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Zero on 2017/3/20.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RouteDao routeDao;
    private StoryDao storyDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RouteDao routeDao, StoryDao storyDao) {
        this.userDao = userDao;
        this.routeDao = routeDao;
        this.storyDao = storyDao;
    }

    @Override
    public ResultVo<UserVo> getUser(String username) {
        UserEntity entity = userDao.findUserByName(username);
        if (entity == null)
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        return new ResultVo<>(ErrorCode.SUCCESS, new UserVo(entity));
    }

    @Override
    @Transactional
    public ResultVo<UserVo> getUser(int id) {
        UserEntity entity = userDao.findUserById(id);
        if (entity == null)
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        return new ResultVo<>(ErrorCode.SUCCESS, new UserVo(entity, true));
    }

    @Override
    public ResultVo<UserVo> updateUser(int id, String avatar, Gender gender, String description) {
        UserEntity entity = userDao.findUserById(id);
        if (entity == null){
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        }
        entity.setAvatar(avatar);
        entity.setGender(gender);
        entity.setDescription(description);

        return new ResultVo<>(new UserVo(entity));
    }

    @Override
    @Transactional
    public ResultVo<RouteVo> saveRoute(int userId, List<Integer> storyIdList, String description) {
        int order = 0;
        RouteEntity routeEntity = new RouteEntity();
        UserEntity userEntity = userDao.findUserById(userId);
        if (userEntity == null){
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        }
        routeEntity.setUserEntity(userEntity);
        routeEntity.setDescription(description);
        List<RouteStoryEntity> routeStoryEntityList = new ArrayList<>();
        for (Integer storyId : storyIdList){
            StoryEntity storyEntity = storyDao.findById(storyId);
            if (storyEntity!=null){
                RouteStoryEntity point = new RouteStoryEntity();
                point.setStoryEntity(storyEntity);
                point.setNum(order);
                routeStoryEntityList.add(point);
                order++;
            }
        }
        routeEntity.setRouteStoryEntities(routeStoryEntityList);
        RouteEntity savedEntity = routeDao.save(routeEntity);
        if (savedEntity == null){
            return new ResultVo<>(ErrorCode.SQL_ERROR, null);
        }
        return new ResultVo<>(ErrorCode.SUCCESS, new RouteVo(savedEntity));
    }

    @Override
    public ResultVo<Void> deleteRoute(int routeId) {
        routeDao.delete(routeId);
        return new ResultVo<>(ErrorCode.SUCCESS, null);
    }

    @Override
    public ResultVo<UserVo> follow(int userId, int followId) {
        //TODO no dao
        return null;
    }

    @Override
    public ResultVo<Void> unfollow(int userId, int followId) {
        //TODO no dao
        return null;
    }

}
