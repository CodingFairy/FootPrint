package com.codingfairy.bl.vo;

import com.codingfairy.data.entity.StoryEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yyy on 2017/3/20.
 */
@Data
public class StoryVo {
    private int id;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private double longitude;
    private double latitude;
    private Double anger;
    private Double contempt;
    private Double disgust;
    private Double fear;
    private Double happiness;
    private Double neutral;
    private Double sadness;
    private Double surprise;
    private List<StoryPicVo> picVos;
    private List<CommentVo> commentVos;
    private List<StarVo> starVos;
    private UserVo author;

    public StoryVo(StoryEntity storyEntity){
        this(storyEntity,false);
    }

    public StoryVo(StoryEntity storyEntity,boolean hasSession){
        BeanUtils.copyProperties(storyEntity,this,"picEntities","commentEntities","starEntities","author");
        if(hasSession){
            picVos = storyEntity.getPicEntities().stream().map(StoryPicVo::new).collect(Collectors.toList());
            commentVos = storyEntity.getCommentEntities().stream().map(CommentVo::new).collect(Collectors.toList());
            starVos = storyEntity.getStarEntities().stream().map(StarVo::new).collect(Collectors.toList());
            author = new UserVo(storyEntity.getAuthor());
        }
    }
}
