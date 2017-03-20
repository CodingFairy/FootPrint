package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.UserDao;
import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.data.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * User dao impl
 * @author cuihao
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity findUserById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserEntity findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserEntity findUserByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public void delete(int id) {
        UserEntity userEntity = userRepository.findOne(id);
        userEntity.setDeletedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
