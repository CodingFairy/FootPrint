package com.codingfairy.bl.vo;

import com.codingfairy.data.entity.RouteEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yyy on 2017/3/20.
 */
@Data
public class RouteVo {
    private int id;
    private String description;
    private List<RouteStoryVo> routeStoryVos;
    private List<StoryVo> storyVos;

    public RouteVo(RouteEntity routeEntity){
        this(routeEntity,false);
    }

    public RouteVo(RouteEntity routeEntity,boolean hasSession){
        BeanUtils.copyProperties(routeEntity,this,"routeStoryEntities");
        if(hasSession){
            routeStoryVos = routeEntity.getRouteStoryEntities().stream().map(RouteStoryVo::new).collect(Collectors.toList());
            storyVos = routeEntity.getStoryEntities().stream().map(StoryVo::new).collect(Collectors.toList());
        }
    }
}
