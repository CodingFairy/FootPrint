package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.AuthService;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.UserVo;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.util.constant.ErrorCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * auth service impl
 * @author cuihao
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserDao userDao;

    @Override
    public ResultVo<UserVo> findUserByName(String name) {
        UserEntity entity = userDao.findUserByName(name);
        if (entity == null)
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        return new ResultVo<>(ErrorCode.SUCCESS, new UserVo(entity));
    }

    @Override
    public ResultVo<UserVo> findUserById(int id) {
        UserEntity entity = userDao.findUserById(id);
        if (entity == null)
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND, null);
        return new ResultVo<>(ErrorCode.SUCCESS, new UserVo(entity));
    }

    @Override
    public ResultVo<UserVo> login(String username, String password) {
        if (userDao.findUserByName(username) == null)
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND,null);
        UserEntity userEntity = userDao.findUserByNameAndPassword(username, password);
        if (userEntity == null)
            return new ResultVo<>(ErrorCode.ERROR_PASSWORD,null);
        return new ResultVo<>(ErrorCode.SUCCESS,new UserVo(userEntity));
    }
}
