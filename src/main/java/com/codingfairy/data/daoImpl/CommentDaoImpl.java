package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.CommentDao;
import com.codingfairy.data.entity.CommentEntity;
import com.codingfairy.data.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Resource
    private CommentRepository commentRepository;

    @Override
    public CommentEntity findById(int id) {
        return commentRepository.findOne(id);
    }

    @Override
    public CommentEntity save(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    @Override
    public void delete(int id) {
        commentRepository.delete(id);
    }
}
