package com.codingfairy.bl.service;

import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.UserVo;

/**
 * Defines user service here
 * @author cuihao
 */
public interface AuthService {
    ResultVo<UserVo> login(String username, String password);

    ResultVo<UserVo> register(String username,String password,String phone,String gender);

}
