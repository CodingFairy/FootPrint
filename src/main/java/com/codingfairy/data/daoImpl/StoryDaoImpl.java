package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.entity.StoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class StoryDaoImpl implements StoryDao {
    @Override
    public StoryEntity findById(int id) {
        return null;
    }

    @Override
    public StoryEntity save(StoryEntity storyEntity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<StoryEntity> findByLocation(double longitude, double latitude, int size) {
        return null;
    }
}
