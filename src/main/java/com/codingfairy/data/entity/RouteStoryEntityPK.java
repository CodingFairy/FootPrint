package com.codingfairy.data.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cuihao on 2017/3/20.
 */
public class RouteStoryEntityPK implements Serializable {
    private int routeId;
    private int storyId;

    @Column(name = "route_id")
    @Id
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Column(name = "story_id")
    @Id
    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteStoryEntityPK that = (RouteStoryEntityPK) o;

        if (routeId != that.routeId) return false;
        if (storyId != that.storyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + storyId;
        return result;
    }
}
