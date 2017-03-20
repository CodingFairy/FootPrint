package com.codingfairy.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by cuihao on 2017/3/20.
 */
@Entity
@Table(name = "story")
public class StoryEntity {
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
    private List<StoryPicEntity> picEntities;
    private List<CommentEntity> commentEntities;
    private List<StarEntity> starEntities;
    private UserEntity author;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "anger")
    public Double getAnger() {
        return anger;
    }

    public void setAnger(Double anger) {
        this.anger = anger;
    }

    @Basic
    @Column(name = "contempt")
    public Double getContempt() {
        return contempt;
    }

    public void setContempt(Double contempt) {
        this.contempt = contempt;
    }

    @Basic
    @Column(name = "disgust")
    public Double getDisgust() {
        return disgust;
    }

    public void setDisgust(Double disgust) {
        this.disgust = disgust;
    }

    @Basic
    @Column(name = "fear")
    public Double getFear() {
        return fear;
    }

    public void setFear(Double fear) {
        this.fear = fear;
    }

    @Basic
    @Column(name = "happiness")
    public Double getHappiness() {
        return happiness;
    }

    public void setHappiness(Double happiness) {
        this.happiness = happiness;
    }

    @Basic
    @Column(name = "neutral")
    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

    @Basic
    @Column(name = "sadness")
    public Double getSadness() {
        return sadness;
    }

    public void setSadness(Double sadness) {
        this.sadness = sadness;
    }

    @Basic
    @Column(name = "surprise")
    public Double getSurprise() {
        return surprise;
    }

    public void setSurprise(Double surprise) {
        this.surprise = surprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoryEntity that = (StoryEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (anger != null ? !anger.equals(that.anger) : that.anger != null) return false;
        if (contempt != null ? !contempt.equals(that.contempt) : that.contempt != null) return false;
        if (disgust != null ? !disgust.equals(that.disgust) : that.disgust != null) return false;
        if (fear != null ? !fear.equals(that.fear) : that.fear != null) return false;
        if (happiness != null ? !happiness.equals(that.happiness) : that.happiness != null) return false;
        if (neutral != null ? !neutral.equals(that.neutral) : that.neutral != null) return false;
        if (sadness != null ? !sadness.equals(that.sadness) : that.sadness != null) return false;
        if (surprise != null ? !surprise.equals(that.surprise) : that.surprise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (anger != null ? anger.hashCode() : 0);
        result = 31 * result + (contempt != null ? contempt.hashCode() : 0);
        result = 31 * result + (disgust != null ? disgust.hashCode() : 0);
        result = 31 * result + (fear != null ? fear.hashCode() : 0);
        result = 31 * result + (happiness != null ? happiness.hashCode() : 0);
        result = 31 * result + (neutral != null ? neutral.hashCode() : 0);
        result = 31 * result + (sadness != null ? sadness.hashCode() : 0);
        result = 31 * result + (surprise != null ? surprise.hashCode() : 0);
        return result;
    }

    @OneToMany
    @JoinColumn(name = "story_id")
    public List<StoryPicEntity> getPicEntities() {
        return picEntities;
    }

    public void setPicEntities(List<StoryPicEntity> picEntities) {
        this.picEntities = picEntities;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    @OneToMany
    @JoinColumn(name = "story_id")
    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    @OneToMany
    @JoinColumn(name = "story_id")
    public List<StarEntity> getStarEntities() {
        return starEntities;
    }

    public void setStarEntities(List<StarEntity> starEntities) {
        this.starEntities = starEntities;
    }
}
