package com.company;

import java.util.Date;

public class Article {
    String id;
    String source_id;
    String source_name;
    String title;
    String content;
    String published_at;

    public Article(String id, String source_id, String source_name, String title, String content, String published_at) {
        this.id = id;
        this.source_id = source_id;
        this.source_name = source_name;
        this.title = title;
        this.content = content;
        this.published_at = published_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", source_id=" + source_id +
                ", source_name='" + source_name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", published_at=" + published_at +
                '}';
    }

    public Date convert(String date){
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        int hour = Integer.parseInt(date.substring(11,13));
        int minute = Integer.parseInt(date.substring(14,16));
        int second = Integer.parseInt(date.substring(17,19));
        Date d = new Date(year,month,day,hour,minute,second);
        return d;
    }
}
