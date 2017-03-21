package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.FollowDao;
import com.codingfairy.data.entity.UserFollowEntity;
import com.codingfairy.data.repository.UserFollowRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017/3/21.
 */
@Repository
public class FollowDaoImpl implements FollowDao {

    @Resource
    private UserFollowRepository userFollowRepository;

    @Override
    public UserFollowEntity save(UserFollowEntity userFollowEntity) {
        return userFollowRepository.save(userFollowEntity);
    }

    @Override
    public UserFollowEntity findById(int id) {
        return userFollowRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        userFollowRepository.delete(id);
    }
}
