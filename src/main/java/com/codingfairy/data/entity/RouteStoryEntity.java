package com.codingfairy.data.entity;

import javax.persistence.*;

/**
 * Created by cuihao on 2017/3/21.
 */
@Entity
@Table(name = "route_story")
public class RouteStoryEntity {
    private Integer num;
    private int id;
    private StoryEntity storyEntity;
    private RouteEntity routeEntity;

    @Basic
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer order) {
        this.num = order;
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

        RouteStoryEntity that = (RouteStoryEntity) o;

        if (id != that.id) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
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

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    public RouteEntity getRouteEntity() {
        return routeEntity;
    }

    public void setRouteEntity(RouteEntity routeEntity) {
        this.routeEntity = routeEntity;
    }
}
