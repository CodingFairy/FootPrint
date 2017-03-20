package com.codingfairy.bl.vo;

import com.codingfairy.data.entity.CommentEntity;
import com.codingfairy.data.entity.UserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Created by yyy on 2017/3/20.
 */
@Data
public class CommentVo {
    private int id;
    private String content;
    private UserVo userVo;

    public CommentVo(CommentEntity commentEntity){
        this(commentEntity,false);
    }

    public CommentVo(CommentEntity commentEntity,boolean hasSession){
        BeanUtils.copyProperties(commentEntity,this,"userEntity");
        if(hasSession){
            userVo = new UserVo(commentEntity.getUserEntity());
        }
    }
}
