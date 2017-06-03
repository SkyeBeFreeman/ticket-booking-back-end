package com.teamid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Skye on 2017/6/2.
 */

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name_cn;

    @Column(nullable = false)
    private String name_en;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String release_time;

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private float rank;

    @Column(nullable = false)
    private String post;

    @Column(nullable = false)
    private long like;

    public Movie() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public long getLike() {
        return like;
    }

    public void setLike(long like) {
        this.like = like;
    }
}
