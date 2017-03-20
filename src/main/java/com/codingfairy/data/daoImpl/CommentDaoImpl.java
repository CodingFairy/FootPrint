package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.CommentDao;
import com.codingfairy.data.entity.CommentEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class CommentDaoImpl implements CommentDao {
    @Override
    public CommentEntity findById(int id) {
        return null;
    }

    @Override
    public CommentEntity save(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
