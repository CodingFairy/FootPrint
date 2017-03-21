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
    private UserEntity userEntity;
    private List<RouteStoryEntity> routeStoryEntities;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "story_id" , referencedColumnName = "id")
    public List<RouteStoryEntity> getRouteStoryEntities() {
        return routeStoryEntities;
    }

    public void setRouteStoryEntities(List<RouteStoryEntity> routeStoryEntities) {
        this.routeStoryEntities = routeStoryEntities;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
