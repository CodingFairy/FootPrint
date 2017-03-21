package com.codingfairy.bl.serviceImpl;

import com.codingfairy.bl.service.AuthService;
import com.codingfairy.bl.vo.ResultVo;
import com.codingfairy.bl.vo.UserVo;
import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.util.constant.ErrorCode;
import com.codingfairy.util.enums.Gender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * auth service impl
 * @author cuihao
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserDao userDao;


    @Override
    public ResultVo<UserVo> login(String username, String password) {
        if (userDao.findUserByName(username) == null)
            return new ResultVo<>(ErrorCode.USER_NOT_FOUND,null);
        UserEntity userEntity = userDao.findUserByNameAndPassword(username, password);
        if (userEntity == null)
            return new ResultVo<>(ErrorCode.ERROR_PASSWORD,null);
        return new ResultVo<>(ErrorCode.SUCCESS,new UserVo(userEntity));
    }

    @Override
    public ResultVo<UserVo> register(String username, String password, String phone,String gender) {
        UserEntity entity = new UserEntity();
        entity.setName(username);
        entity.setPassword(password);
        entity.setPhone(phone);
        entity.setGender(Gender.valueOf(gender));
        entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        entity.setValid(0);//尚未验证
        UserEntity savedEntity = userDao.save(entity);
        if (savedEntity == null){    //用户名或手机重复
            return new ResultVo<>(ErrorCode.USERNAME_DUPLICATE, null);
        } else {
            return new ResultVo<>(ErrorCode.SUCCESS, new UserVo(savedEntity));
        }
        //TODO 验证手机号
    }
}
