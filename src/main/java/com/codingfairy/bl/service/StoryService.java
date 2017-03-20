package com.codingfairy.bl.service;

import com.codingfairy.bl.vo.*;

import java.util.List;

/**
 * Service about Story
 */
public interface StoryService {
    ResultVo<StoryVo> createStory(StoryVo storyVo);

    ResultVo<StoryVo> deleteStory(int storyId);

    ResultVo<StarVo> starStory(int userId, int storyId);

    void unStarStory(int userId,int storyId);

    ResultVo<CommentVo> comment(CommentVo commentVo);

    void deleteComment(int commentId);

    List<CommentVo> getCommentList(int storyId);

    List<StoryVo> getStoryList(double longitude, double latitude, int num);

    List<RouteVo> getRouteList(int userId);

    List<StoryVo> getRecommendStory(double longitude,double latitude);


}
