package com.teamid.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wangzf on 2017/6/6.
 */
public class MovieDetail {

    private long id;
    private String nameCn;
    private String nameEn;
    private int type;
    private String origin;
    private String duration;
    private String releaseTime;
    private String introduction;
    private float rank;
    private String post;
    private long likes;

    private List<ScheduleBean> scheduleBeans;

    public MovieDetail(Movie movie, List<ScheduleBean> scheduleBeans) {
        this.id = movie.getId();
        this.nameCn = movie.getNameCn();
        this.nameEn = movie.getNameEn();
        this.type = movie.getType();
        this.origin = movie.getOrigin();
        this.duration = movie.getDuration();
        this.releaseTime = movie.getReleaseTime();
        this.introduction = movie.getIntroduction();
        this.rank = movie.getRank();
        this.post = movie.getPost();
        this.likes = movie.getLike();

        this.scheduleBeans = scheduleBeans.stream().filter(
                scheduleBean -> this.id == scheduleBean.getMovieId()
        ).collect(Collectors.toList());
    }

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

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public List<ScheduleBean> getScheduleBeans() {
        return scheduleBeans;
    }

    public void setScheduleBeans(List<ScheduleBean> scheduleBeans) {
        this.scheduleBeans = scheduleBeans;
    }
}
