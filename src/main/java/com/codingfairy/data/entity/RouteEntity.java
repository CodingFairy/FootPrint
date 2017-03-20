package com.codingfairy.data.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cuihao on 2017/3/20.
 */
@Entity
@Table(name = "route")
public class RouteEntity {
    private int id;
    private String description;
    //set this when create
    private List<RouteStoryEntity> routeStoryEntities;
    //get stories
    private List<StoryEntity> storyEntities;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteEntity that = (RouteEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany
    @JoinColumn(name = "story_id" , referencedColumnName = "id")
    public List<RouteStoryEntity> getRouteStoryEntities() {
        return routeStoryEntities;
    }

    public void setRouteStoryEntities(List<RouteStoryEntity> routeStoryEntities) {
        this.routeStoryEntities = routeStoryEntities;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "route_story", schema = "footprint",
            joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "story_id", referencedColumnName = "id",nullable = false))
    public List<StoryEntity> getStoryEntities() {
        return storyEntities;
    }

    public void setStoryEntities(List<StoryEntity> storyEntities) {
        this.storyEntities = storyEntities;
    }
}
