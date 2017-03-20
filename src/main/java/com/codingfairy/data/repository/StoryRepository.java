package com.codingfairy.data.repository;

import com.codingfairy.data.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * story repository
 * @author cuihao
 */
public interface StoryRepository extends JpaRepository<StoryEntity,Integer> {

    @Query("from StoryEntity " +
            "where 6371 * acos(cos(radians(:latitude))*cos(radians(latitude))*cos(radians(longitude)-radians(:longitude))+sin(radians(:latitude))*sin(radians(latitude))) < 3 " +
            "order by 6371 * acos(cos(radians(:latitude))*cos(radians(latitude))*cos(radians(longitude)-radians(:longitude))+sin(radians(:latitude))*sin(radians(latitude))) asc ")
    List<StoryEntity> findByLocation(@Param("longitude") double longitude,
                                     @Param("latitude") double latitude);
}
