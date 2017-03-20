package com.codingfairy.data.entity;

import com.codingfairy.util.enums.Gender;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * user entity
 */
@Entity
@Where(clause="deleted_at is null")
@Table(name = "user")
public class UserEntity {
    private int id;
    private String name;
    private String password;
    private String avatar;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer valid;
    private Timestamp deletedAt;
    private Gender gender;
    private String description;
    private List<UserEntity> following;
    private List<UserEntity> follower;
    private List<StoryEntity> userStories;
    private List<CommentEntity> commentEntities;
    private List<RouteEntity> routeEntities;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "valid")
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_follow", schema = "footprint",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "follow_id", referencedColumnName = "id",nullable = false))
    public List<UserEntity> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserEntity> following) {
        this.following = following;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_follow", schema = "footprint",
            joinColumns = @JoinColumn(name = "follow_id", referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false))
    public List<UserEntity> getFollower() {
        return follower;
    }

    public void setFollower(List<UserEntity> follower) {
        this.follower = follower;
    }

    @OneToMany
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    public List<StoryEntity> getUserStories() {
        return userStories;
    }

    public void setUserStories(List<StoryEntity> userStories) {
        this.userStories = userStories;
    }

    @OneToMany
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    @OneToMany
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    public List<RouteEntity> getRouteEntities() {
        return routeEntities;
    }

    public void setRouteEntities(List<RouteEntity> routeEntities) {
        this.routeEntities = routeEntities;
    }
}
