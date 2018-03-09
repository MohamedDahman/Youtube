package com.example.demo.model;

import java.util.Date;
import java.util.List;


public class Video {

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;
    private String video_id	;
    private Date trending_date;
    private String title	;
    private String channel_title;
    private Integer category_id;
    private List<String> tags;
    private Integer views;
    private Integer likes;
    private Integer dislikes;
    private Integer comment_count;
    private String thumbnail_link;
    private String description;

    @Override
    public String toString() {
        return "Video{" +
                "Country ='" + country + '\'' +
                ", video_id='" + video_id + '\'' +
                ", title='" + title + '\'' +
                ", channel_title='" + channel_title + '\'' +
                ", category_id=" + category_id +
                ", views=" + views +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public Date getTrending_date() {
        return trending_date;
    }

    public void setTrending_date(Date trending_date) {
        this.trending_date = trending_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannel_title() {
        return channel_title;
    }

    public void setChannel_title(String channel_title) {
        this.channel_title = channel_title;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public String getThumbnail_link() {
        return thumbnail_link;
    }

    public void setThumbnail_link(String thumbnail_link) {
        this.thumbnail_link = thumbnail_link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Video()
    {

    }
    public Video(String video_id, Date trending_date, String title, String channel_title, Integer category_id, List<String> tags, Integer views, Integer likes, Integer dislikes, Integer comment_count, String thumbnail_link, String description) {
        this.video_id = video_id;
        this.trending_date = trending_date;
        this.title = title;
        this.channel_title = channel_title;
        this.category_id = category_id;
        this.tags = tags;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comment_count = comment_count;
        this.thumbnail_link = thumbnail_link;
        this.description = description;
    }
}
