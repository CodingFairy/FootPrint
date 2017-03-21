package com.codingfairy.data.entity;

import javax.persistence.*;

/**
 * Created by cuihao on 2017/3/21.
 */
@Entity
@Table(name = "user_follow", schema = "footprint", catalog = "")
public class UserFollowEntity {
    private int userId;
    private int followId;
    private int id;

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "follow_id")
    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFollowEntity that = (UserFollowEntity) o;

        if (userId != that.userId) return false;
        if (followId != that.followId) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + followId;
        result = 31 * result + id;
        return result;
    }
}
