package com.codingfairy.data.dao;

import com.codingfairy.data.entity.UserEntity;

/**
 * user dao
 */
public interface UserDao {
    UserEntity findUserById(int id);
    UserEntity findUserByName(String name);
    UserEntity findUserByNameAndPassword(String name, String password);
    void delete(int id);
    UserEntity save(UserEntity userEntity);
}
