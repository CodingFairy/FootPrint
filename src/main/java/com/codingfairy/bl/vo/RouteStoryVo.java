package com.codingfairy.bl.vo;

import com.codingfairy.data.entity.RouteStoryEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Created by yyy on 2017/3/20.
 */
@Data
public class RouteStoryVo {
    private int routeId;
    private int storyId;
    private Integer order;
    private StoryVo storyVo;

    public RouteStoryVo(RouteStoryEntity routeStoryEntity){
        BeanUtils.copyProperties(routeStoryEntity,this,"storyEntity");
        //storyVo wait to be set
    }
}
