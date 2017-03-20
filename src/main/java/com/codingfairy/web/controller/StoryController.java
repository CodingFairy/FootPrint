package com.codingfairy.web.controller;

import com.codingfairy.bl.service.StoryService;
import com.codingfairy.bl.vo.CommentVo;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.StarVo;
import com.codingfairy.bl.vo.StoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yyy on 2017/3/20.
 */

@Api(value = "/story", description = "Application story API")
@RestController
@RequestMapping("/api/v1/story")
public class StoryController {
    @Resource
    private StoryService storyService;

    @ApiOperation(value = "Release a story", notes = "Release a story",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/release/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<StoryVo> releaseStory(@PathVariable int userId, @RequestParam String content,
                                          @RequestParam double longitude, @RequestParam double latitude,
                                          @RequestParam List<String> imgUrls){
        return storyService.createStory(userId,content,longitude,latitude,imgUrls);
    }

    @ApiOperation(value = "Delete a story", notes = "Delete a story",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/delete/{storyId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<StoryVo> deleteStory(@PathVariable int storyId){
        return storyService.deleteStory(storyId);
    }

    @ApiOperation(value = "Star a story", notes = "Star a story",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/star/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<StarVo> starStory(@PathVariable int userId, @RequestParam int storyId){
        return storyService.starStory(userId,storyId);
    }

    @ApiOperation(value = "unStar a story", notes = "Cancel star a story",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/unstar/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<Void> unstarStory(@PathVariable int userId,@RequestParam int storyId){
        return storyService.unStarStory(userId,storyId);
    }

    @ApiOperation(value = "Comment a story", notes = "Comment a story",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/comment/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<CommentVo> commentStory(@PathVariable int userId, @RequestParam int storyId,
                                            @RequestParam String content, @RequestParam int parentId){
        return storyService.comment(userId,storyId,content,parentId);
    }

    @ApiOperation(value = "Delete comment on a story", notes = "Delete comment on a story",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/delComment/{commentId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<Void> delComment(@PathVariable int commentId){
        return storyService.deleteComment(commentId);
    }

    @ApiOperation(value = "get comment list", notes = "get comment list of a story",
            response = ResultVo.class, responseContainer = "List", produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/commentList/{storyId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CommentVo> getCommentList(@PathVariable int storyId){
        return storyService.getCommentList(storyId);
    }

    @ApiOperation(value = "get story list", notes = "get story list in a distance",
            response = ResultVo.class, responseContainer = "List", produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/storyList",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StoryVo> getStoryList(@RequestParam double longitude,@RequestParam double latitude,
                                        @RequestParam int num){
        return storyService.getStoryList(longitude,latitude,num);
    }

    @ApiOperation(value = "get a specific story", notes = "get a specific story when the requirements meet",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/storyDetail/{storyId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<StoryVo> getStory(@PathVariable int storyId){
        return storyService.getStory(storyId);
    }

    @ApiOperation(value = "get recommend story list", notes = "get recommend story list in a distance",
            response = ResultVo.class, responseContainer = "List", produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/recommend",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StoryVo> getRecommendStories(@RequestParam double logitude,@RequestParam double latitude){
        return storyService.getRecommendStory(logitude, latitude);
    }



}
