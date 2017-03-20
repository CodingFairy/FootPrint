package com.codingfairy.bl.vo;

import lombok.Data;

import java.sql.Timestamp;

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
}
