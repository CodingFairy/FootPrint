package com.codingfairy.data.entity;

import javax.persistence.*;

/**
 * Created by cuihao on 2017/3/20.
 */
@Entity
@Table(name = "route_story")
@IdClass(RouteStoryEntityPK.class)
public class RouteStoryEntity {
    private int routeId;
    private int storyId;
    private Integer order;

    @Id
    @Column(name = "route_id")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "story_id")
    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    @Basic
    @Column(name = "order")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteStoryEntity that = (RouteStoryEntity) o;

        if (routeId != that.routeId) return false;
        if (storyId != that.storyId) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + storyId;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
