package com.codingfairy.data.dao;

import com.codingfairy.data.entity.StoryPicEntity;

/**
 * Created by cuihao on 2017/3/20.
 */
public interface StoryPictureDao {
    StoryPicEntity save(StoryPicEntity storyPicEntity);
    void delete(int id);
    StoryPicEntity findById(int id);
}
