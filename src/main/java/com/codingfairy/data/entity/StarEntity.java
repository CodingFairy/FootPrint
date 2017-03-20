package com.codingfairy.data.entity;

import javax.persistence.*;

/**
 * Created by cuihao on 2017/3/20.
 */
@Entity
@Table(name = "star")
public class StarEntity {
    private int id;
    private UserEntity userEntity;
    private StoryEntity storyEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        StarEntity that = (StarEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @ManyToOne
    @JoinColumn(name = "story_id", referencedColumnName = "id")
    public StoryEntity getStoryEntity() {
        return storyEntity;
    }

    public void setStoryEntity(StoryEntity storyEntity) {
        this.storyEntity = storyEntity;
    }
}
