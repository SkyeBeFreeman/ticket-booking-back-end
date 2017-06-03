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
    private String nameCn;

    @Column(nullable = false)
    private String nameEn;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String releaseTime;

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private float rank;

    @Column(nullable = false)
    private String post;

    @Column(nullable = false)
    private long likes;

    public Movie() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
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

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
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
        return likes;
    }

    public void setLike(long likes) {
        this.likes = likes;
    }
}
