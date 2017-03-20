package com.codingfairy.web.controller;

import com.codingfairy.bl.vo.*;
import com.codingfairy.util.enums.Gender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yyy on 2017/3/20.
 */
@Api(value="/user", description = "Application user API")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @ApiOperation(value = "Get user info", notes = "Get detail info of a user",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<UserVo> getInfo(@PathVariable int id){
        return null;
    }

    @ApiOperation(value = "edit user info", notes = "edit user's detail info",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<UserVo> editInfo(@PathVariable int id, @RequestParam String avatar,
                                     @RequestParam Gender gender,@RequestParam String description){
        return null; //to do
    }

    @ApiOperation(value = "make the route", notes = "make route by combining stories",
                response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/makeRoute/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<RouteVo> makeRoute(@PathVariable int id,@RequestParam List<StoryVo> storyVos){
        return null;
    }

}
