package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.StoryService;
import com.codingfairy.bl.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.Zero on 2017/3/20.
 */
@Service
public class StoryServiceImpl implements StoryService {

    @Override
    public ResultVo<StoryVo> createStory(int userId, String content, double longitude, double latitude, List<String> imgUrlList) {
        return null;
    }

    @Override
    public ResultVo<StoryVo> deleteStory(int storyId) {
        return null;
    }

    @Override
    public ResultVo<StoryVo> getStory(int storyId) {
        return null;
    }

    @Override
    public ResultVo<StarVo> starStory(int userId, int storyId) {
        return null;
    }

    @Override
    public ResultVo<Void> unStarStory(int userId, int storyId) {
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
}
