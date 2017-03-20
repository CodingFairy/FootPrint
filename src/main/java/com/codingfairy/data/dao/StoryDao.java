package com.codingfairy.data.dao;

import com.codingfairy.data.entity.StoryEntity;

import java.util.List;

/**
 * story dao
 * @author cuihao
 */
public interface StoryDao {
    StoryEntity findById(int id);
    StoryEntity save(StoryEntity storyEntity);
    void delete(int id);
    List<StoryEntity> findByLocation(double longitude, double latitude, int size);
}
