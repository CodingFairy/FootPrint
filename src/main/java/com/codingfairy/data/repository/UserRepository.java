package com.codingfairy.data.repository;

import com.codingfairy.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * user repository
 * @author cuihao
 */
public interface UserRepository extends CrudRepository<UserEntity,Integer>{
    UserEntity findByName(String name);
    UserEntity findByNameAndPassword(String name, String password);
}
