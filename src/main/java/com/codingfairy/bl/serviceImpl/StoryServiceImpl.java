package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.RecognizeService;
import com.codingfairy.bl.service.StoryService;
import com.codingfairy.bl.vo.*;
import com.codingfairy.data.dao.CommentDao;
import com.codingfairy.data.dao.StarDao;
import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.*;
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
    private CommentDao commentDao;
    private RecognizeService recognizeService;

    @Autowired
    public StoryServiceImpl(UserDao userDao, StoryDao storyDao, StarDao starDao, CommentDao commentDao, RecognizeService recognizeService) {
        this.userDao = userDao;
        this.storyDao = storyDao;
        this.starDao = starDao;
        this.commentDao = commentDao;
        this.recognizeService = recognizeService;
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
    public ResultVo<Void> unStarStory(int starId) {
        starDao.delete(starId);
        return new ResultVo<>(ErrorCode.SUCCESS, null);
    }

    @Override
    @Transactional
    public ResultVo<CommentVo> comment(int userId, int storyId, String content, int parent) {
        UserEntity userEntity = userDao.findUserById(userId);
        if (userEntity == null) {
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        }
        StoryEntity storyEntity = storyDao.findById(storyId);
        if (storyEntity == null){
            return new ResultVo<>(ErrorCode.STORY_NOT_FOUND, null);
        }
        CommentEntity entity = new CommentEntity();
        entity.setUserEntity(userEntity);
        entity.setStoryEntity(storyEntity);
        //<0表示这个评论不存在父评论s
        if (userId<0){
            entity.setParentComment(null);
        } else {
            entity.setParentComment(commentDao.findById(parent));
        }
        entity.setContent(content);
        CommentEntity savedEntity = commentDao.save(entity);
        if (savedEntity == null){
            return new ResultVo<>(ErrorCode.SQL_ERROR, null);
        }
        return new ResultVo<>(ErrorCode.SUCCESS, new CommentVo(savedEntity, true));
    }

    @Override
    public ResultVo<Void> deleteComment(int commentId) {
        commentDao.delete(commentId);
        return new ResultVo<>(ErrorCode.SUCCESS, null);
    }

    @Override
    public List<CommentVo> getCommentList(int storyId) {
        //todo no dao
        return null;
    }

    @Override
    public List<StoryVo> getStoryList(double longitude, double latitude, int num) {
        List<StoryEntity> entityList = storyDao.findByLocation(longitude, latitude, num);
        List<StoryVo> voList = new ArrayList<>();
        for (StoryEntity po : entityList) {
            voList.add(new StoryVo(po));
        }
        return voList;
    }

    @Override
    public List<RouteVo> getRouteList(int userId) {
        //todo no dao
        return null;
    }

    @Override
    public List<StoryVo> getRecommendStory(double longitude, double latitude) {
        //TODO recommend ???
        return null;
    }

    private void analyzeEmotion(int storyId, List<String> imageUrlList){
        Thread thread = new Thread(() -> {
            double anger = 0.0;
            double contempt = 0.0;
            double disgust = 0.0;
            double fear = 0.0;
            double happiness = 0.0;
            double neutral = 0.0;
            double sadness = 0.0;
            double surprise = 0.0;
            int count = 0;
            for (String imgUrl : imageUrlList){
                EmotionVo emotionVo = recognizeService.getImageEmotion(imgUrl);
                if (emotionVo!=null){
                    anger+=emotionVo.getAnger();
                    contempt+=emotionVo.getContempt();
                    disgust+=emotionVo.getDisgust();
                    fear+=emotionVo.getFear();
                    happiness+=emotionVo.getHappiness();
                    neutral+=emotionVo.getNeutral();
                    sadness+=emotionVo.getSadness();
                    surprise+=emotionVo.getSurprise();
                    count++;
                }
            }
            StoryEntity storyEntity = storyDao.findById(storyId);
            if (storyEntity!=null){
                storyEntity.setAnger(anger/count);
                storyEntity.setContempt(contempt/count);
                storyEntity.setDisgust(disgust/count);
                storyEntity.setFear(fear/count);
                storyEntity.setHappiness(happiness/count);
                storyEntity.setNeutral(neutral/count);
                storyEntity.setSadness(sadness/count);
                storyEntity.setSurprise(surprise/count);
                storyDao.save(storyEntity);
            }
        });
        thread.start();
    }
}
