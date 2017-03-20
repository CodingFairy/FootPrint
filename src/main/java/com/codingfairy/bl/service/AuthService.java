package com.codingfairy.bl.service;

import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.UserVo;

/**
 * Defines user service here
 * @author cuihao
 */
public interface AuthService {
    ResultVo<UserVo> findUserByName(String name);
    ResultVo<UserVo> findUserById(int id);
    ResultVo<UserVo> login(String username, String password);
}
