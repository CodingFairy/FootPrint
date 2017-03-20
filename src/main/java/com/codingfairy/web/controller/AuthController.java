package com.codingfairy.web.controller;

import com.codingfairy.bl.service.AuthService;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * authority verification web controller
 * @author cuihao
 */
@Api(value = "/auth", description = "Auth API")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @ApiOperation(value = "Get user info",notes = "Get user basic info.",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<UserVo> findUserById(@PathVariable int id) {
        return authService.findUserById(id);
    }

    @ApiOperation(value = "Login operation",notes = "Login operation",
            response = ResultVo.class, produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<UserVo> login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

}
