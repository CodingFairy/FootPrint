package com.codingfairy.bl.vo;

import com.codingfairy.data.entity.StoryPicEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Created by yyy on 2017/3/20.
 */
@Data
public class StoryPicVo {
    private String url;
    private int id;

    public StoryPicVo(StoryPicEntity storyPicEntity){
        BeanUtils.copyProperties(storyPicEntity,this);
    }
}
