package com.codingfairy.bl.service;

import com.codingfairy.bl.vo.*;

import java.util.List;

/**
 * Service about Story
 */
public interface StoryService {
    ResultVo<StoryVo> createStory(int userId,String content,double longitude,double latitude,
                                  List<String> imgUrlList);

    ResultVo<StoryVo> deleteStory(int storyId);

    ResultVo<StoryVo> getStory(int storyId);

    ResultVo<StarVo> starStory(int userId, int storyId);

    ResultVo<Void> unStarStory(int starId);

    ResultVo<CommentVo> comment(int userId,int storyId,String content,int parent);

    ResultVo<Void> deleteComment(int commentId);

    List<CommentVo> getCommentList(int storyId);

    List<StoryVo> getStoryList(double longitude, double latitude, int num);

    List<RouteVo> getRouteList(int userId);

    List<StoryVo> getRecommendStory(double longitude,double latitude);

}
