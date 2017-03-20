package com.codingfairy.bl.vo;

import com.codingfairy.data.entity.StarEntity;
import org.springframework.beans.BeanUtils;

/**
 * Created by yyy on 2017/3/20.
 */
public class StarVo {
    private int id;
    private UserVo userVo;

    public StarVo(StarEntity starEntity){
        this(starEntity,false);
    }

    public StarVo(StarEntity starEntity, boolean hasSession){
        BeanUtils.copyProperties(starEntity,this,"userEntity");
        if(hasSession){
            userVo = new UserVo(starEntity.getUserEntity());
        }
    }
}
