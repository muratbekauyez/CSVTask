package com.company;

import java.util.ArrayList;

public class Report {
    private String id;
    private String source_name;
    private String source_id;
    private String published_from;
    private String published_to;
    private String Avg_content_length;


    public Report(String id, String source_name, String source_id) {
        this.id = id;
        this.source_id = source_id;
        this.source_name = source_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getPublished_from() {
        return published_from;
    }

    public void setPublished_from(String published_from) {
        this.published_from = published_from;
    }

    public String getPublished_to() {
        return published_to;
    }

    public void setPublished_to(String published_to) {
        this.published_to = published_to;
    }

    public String getAvg_content_length() {
        return Avg_content_length;
    }

    public void setAvg_content_length(String avg_content_length) {
        Avg_content_length = avg_content_length;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", source_name='" + source_name + '\'' +
                ", source_id='" + source_id + '\'' +
                ", published_from='" + published_from + '\'' +
                ", published_to='" + published_to + '\'' +
                ", Avg_content_length='" + Avg_content_length + '\'' +
                '}';
    }
}
