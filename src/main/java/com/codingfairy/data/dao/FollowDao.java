package com.codingfairy.data.dao;

import com.codingfairy.data.entity.UserFollowEntity;

/**
 * Created by cuihao on 2017/3/21.
 */
public interface FollowDao {

    UserFollowEntity save(UserFollowEntity userFollowEntity);

    UserFollowEntity findById(int id);

    void delete(int id);

}
