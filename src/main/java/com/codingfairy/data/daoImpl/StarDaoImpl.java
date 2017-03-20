package com.codingfairy.data.daoImpl;

import com.codingfairy.data.dao.StarDao;
import com.codingfairy.data.entity.StarEntity;
import com.codingfairy.data.repository.StarRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cuihao on 2017/3/20.
 */
@Repository
public class StarDaoImpl implements StarDao {

    @Resource
    private StarRepository starRepository;

    @Override
    public StarEntity save(StarEntity starEntity) {
        return starRepository.save(starEntity);
    }

    @Override
    public StarEntity findById(int id) {
        return starRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        starRepository.delete(id);
    }
}
