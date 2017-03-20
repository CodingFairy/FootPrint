package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.StoryPictureDao;
import com.codingfairy.data.entity.StoryPicEntity;
import com.codingfairy.data.repository.StoryPicRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class StoryPictureDaoImpl implements StoryPictureDao {

    @Resource
    private StoryPicRepository storyPicRepository;

    @Override
    public StoryPicEntity save(StoryPicEntity storyPicEntity) {
        return storyPicRepository.save(storyPicEntity);
    }

    @Override
    public void delete(int id) {
        storyPicRepository.delete(id);
    }

    @Override
    public StoryPicEntity findById(int id) {
        return storyPicRepository.findOne(id);
    }
}
