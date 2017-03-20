package com.codingfairy.bl.vo;


import com.codingfairy.data.entity.UserEntity;
import com.codingfairy.util.enums.Gender;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserVo {
    private int id;
    private String name;
    private String password;
    private String avatar;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer valid;
    private Gender gender;
    private String description;
    private List<UserVo> following;
    private List<UserVo> followed;
    private List<StoryVo> storyVos;
    private List<CommentVo> commentVos;
    private List<RouteVo> routeVos;

    public UserVo(UserEntity userEntity) {
        this(userEntity,false);
    }

    public UserVo(UserEntity userEntity,boolean hasSession){
        BeanUtils.copyProperties(userEntity,this,"deletedAt","password");
        if(hasSession){
            following = userEntity.getFollowing().stream().map(UserVo::new).collect(Collectors.toList());
            followed = userEntity.getFollower().stream().map(UserVo::new).collect(Collectors.toList());
            storyVos = userEntity.getUserStories().stream().map(StoryVo::new).collect(Collectors.toList());
            commentVos = userEntity.getCommentEntities().stream().map(CommentVo::new).collect(Collectors.toList());
            routeVos = userEntity.getRouteEntities().stream().map(RouteVo::new).collect(Collectors.toList());
        }
    }
}
