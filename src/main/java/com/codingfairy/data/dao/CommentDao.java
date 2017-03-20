package com.codingfairy.data.dao;

import com.codingfairy.data.entity.CommentEntity;

/**
 * Created by cuihao on 2017/3/20.
 */
public interface CommentDao {
    CommentEntity findById(int id);
    CommentEntity save(int id);
    void delete(int id);
}
