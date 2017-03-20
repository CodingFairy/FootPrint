package com.codingfairy.data.entity;

import javax.persistence.*;

/**
 * story picture entity
 */
@Entity
@Table(name = "story_pic")
public class StoryPicEntity {
    private String url;
    private int id;
    private StoryEntity storyEntity;

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

        StoryPicEntity that = (StoryPicEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + id;
        return result;
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
