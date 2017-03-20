package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.StarDao;
import com.codingfairy.data.entity.StarEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class StarDaoImpl implements StarDao {
    @Override
    public StarEntity save(StarEntity starEntity) {
        return null;
    }

    @Override
    public StarEntity findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
