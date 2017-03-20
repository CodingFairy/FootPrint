package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.StoryDao;
import com.codingfairy.data.entity.StoryEntity;
import com.codingfairy.data.repository.StoryRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class StoryDaoImpl implements StoryDao {

    @Resource
    private StoryRepository storyRepository;

    @Override
    public StoryEntity findById(int id) {
        return storyRepository.findOne(id);
    }

    @Override
    public StoryEntity save(StoryEntity storyEntity) {
        return storyRepository.save(storyEntity);
    }

    @Override
    public void delete(int id) {
        storyRepository.delete(id);
    }

    @Override
    public List<StoryEntity> findByLocation(double longitude, double latitude, int size) {
        return null;
    }
}
