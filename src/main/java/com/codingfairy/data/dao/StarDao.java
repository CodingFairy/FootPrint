package com.codingfairy.data.dao;

import com.codingfairy.data.entity.StarEntity;

/**
 * Created by cuihao on 2017/3/20.
 */
public interface StarDao {
    StarEntity save(StarEntity starEntity);
    StarEntity findById(int id);
    void delete(int id);
}
