package com.codingfairy.web.controller;

import com.codingfairy.bl.service.StoryService;
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




}
