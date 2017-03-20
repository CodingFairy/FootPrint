package com.codingfairy.data.repository;

import com.codingfairy.data.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cuihao on 2017/3/20.
 */
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
}
