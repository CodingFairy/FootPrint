package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.UserService;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.RouteVo;
import com.codingfairy.bl.vo.UserVo;
import com.codingfairy.data.dao.*;
import com.codingfairy.data.entity.*;
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
    private FollowDao followDao;
    private RouteStoryDao routeStoryDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RouteDao routeDao, StoryDao storyDao, FollowDao followDao, RouteStoryDao routeStoryDao) {
        this.userDao = userDao;
        this.routeDao = routeDao;
        this.storyDao = storyDao;
        this.followDao = followDao;
        this.routeStoryDao = routeStoryDao;
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
        UserEntity savedEntity = userDao.save(entity);
        return new ResultVo<>(ErrorCode.SUCCESS, new UserVo(savedEntity));
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
        routeEntity = routeDao.save(routeEntity);
        List<RouteStoryEntity> routeStoryEntityList = new ArrayList<>();
        for (Integer storyId : storyIdList){
            StoryEntity storyEntity = storyDao.findById(storyId);
            if (storyEntity!=null){
                RouteStoryEntity point = new RouteStoryEntity();
                point.setStoryEntity(storyEntity);
                point.setNum(order);
                point.setRouteEntity(routeEntity);
                point = routeStoryDao.save(point);
                routeStoryEntityList.add(point);
                order++;
            }
        }
//        routeEntity.setRouteStoryEntities(routeStoryEntityList);
//        RouteEntity savedEntity = routeDao.save(routeEntity);
        RouteEntity savedEntity = routeDao.findById(routeEntity.getId());
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
    public ResultVo<Boolean> follow(int userId, int followId) {
        UserFollowEntity followEntity = new UserFollowEntity();
        followEntity.setUserId(userId);
        followEntity.setFollowId(followId);
        followDao.save(followEntity);
        return new ResultVo<>(ErrorCode.SUCCESS, true);
    }

    @Override
    public ResultVo<Void> unfollow(int id) {
        followDao.delete(id);
        return new ResultVo<>(ErrorCode.SUCCESS, null);
    }

}
