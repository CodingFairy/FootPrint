package com.codingfairy.web.controller;

import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.UserVo;
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
    public ResultVo<UserVo> editInfo(@PathVariable int id){
        return null; //to do
    }

    @ApiOperation(value = "get following list", notes = "get the users followed by this user, just names",
            response = String.class, responseContainer = "List", produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/following/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> getFollowingList(@PathVariable int id){
        return null;
    }

    @ApiOperation(value = "get followed list", notes = "get the users who follow this user,just names",
            response = String.class, responseContainer = "List", produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/followed/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> getFollowedList(@PathVariable int id){
        return null;
    }


//    @ApiOperation(value = "get story list", notes = "get the stories released by this user",
//            response = String.class, responseContainer = "List", produces = "application/json;charset=UTF-8")
//    @PostMapping(value = "/story/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<String> getPesonalStoryList(@PathVariable int id){
//        return null;
//    }

}
