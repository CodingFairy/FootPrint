package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.StoryService;
import com.codingfairy.bl.vo.*;
import com.codingfairy.data.dao.StarDao;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.StarEntity;
import com.codingfairy.data.entity.StoryEntity;
import com.codingfairy.data.entity.StoryPicEntity;
import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.util.constant.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Zero on 2017/3/20.
 */
@Service
public class StoryServiceImpl implements StoryService {

    private UserDao userDao;
    private StoryDao storyDao;
    private StarDao starDao;

    @Autowired
    public StoryServiceImpl(UserDao userDao, StoryDao storyDao, StarDao starDao) {
        this.userDao = userDao;
        this.storyDao = storyDao;
        this.starDao = starDao;
    }

    @Override
    @Transactional
    public ResultVo<StoryVo> createStory(int userId, String content, double longitude, double latitude, List<String> imgUrlList) {
        UserEntity author = userDao.findUserById(userId);
        if (author == null){
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        }
        StoryEntity storyEntity = new StoryEntity();
        storyEntity.setAuthor(author);
        storyEntity.setContent(content);
        storyEntity.setLongitude(longitude);
        storyEntity.setLatitude(latitude);
        List<StoryPicEntity> imageEntityList = new ArrayList<>();
        for (String url : imgUrlList){
            StoryPicEntity image = new StoryPicEntity();
            image.setUrl(url);
            imageEntityList.add(image);
        }
        storyEntity.setPicEntities(imageEntityList);
        StoryEntity savedEntity = storyDao.save(storyEntity);
        if (savedEntity == null) {
            return new ResultVo<>(ErrorCode.SQL_ERROR, null);
        }
        analyzeEmotion(savedEntity.getId(), imgUrlList);
        return new ResultVo<>(ErrorCode.SUCCESS, new StoryVo(savedEntity));
    }

    @Override
    public ResultVo<StoryVo> deleteStory(int storyId) {
        storyDao.delete(storyId);
        return new ResultVo<>(ErrorCode.SUCCESS, null);
    }

    @Override
    @Transactional
    public ResultVo<StoryVo> getStory(int storyId) {
        StoryEntity entity = storyDao.findById(storyId);
        if (entity == null){
            return new ResultVo<>(ErrorCode.STORY_NOT_FOUND, null );
        }
        return new ResultVo<>(ErrorCode.SUCCESS, new StoryVo(entity, true));
    }

    @Override
    @Transactional
    public ResultVo<StarVo> starStory(int userId, int storyId) {
        UserEntity userEntity = userDao.findUserById(userId);
        StoryEntity storyEntity = storyDao.findById(storyId);
        if (userEntity == null){
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        }
        if (storyEntity == null) {
            return new ResultVo<>(ErrorCode.STORY_NOT_FOUND, null);
        }
        StarEntity starEntity = new StarEntity();
        starEntity.setUserEntity(userEntity);
        starEntity.setStoryEntity(storyEntity);
        StarEntity savedEntity = starDao.save(starEntity);
        if (savedEntity == null){
            return new ResultVo<>(ErrorCode.SQL_ERROR, null);
        }
        return new ResultVo<>(ErrorCode.SUCCESS, new StarVo(savedEntity, true));
    }

    @Override
    public ResultVo<Void> unStarStory(int userId, int storyId) {
        //TODO no dao
        return null;
    }

    @Override
    public ResultVo<CommentVo> comment(int userId, int storyId, String content, int parent) {
        return null;
    }

    @Override
    public ResultVo<Void> deleteComment(int commentId) {
        return null;
    }

    @Override
    public List<CommentVo> getCommentList(int storyId) {
        return null;
    }

    @Override
    public List<StoryVo> getStoryList(double longitude, double latitude, int num) {
        return null;
    }

    @Override
    public List<RouteVo> getRouteList(int userId) {
        return null;
    }

    @Override
    public List<StoryVo> getRecommendStory(double longitude, double latitude) {
        return null;
    }

    private void analyzeEmotion(int storyId, List<String> imageUrlList){

    }
}
