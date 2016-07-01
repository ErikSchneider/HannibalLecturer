package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by Erik on 7/1/16.
 */
@Entity
@Table(name = "lecturers")
public class Lecturers {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String topic;

    @Column(nullable = false)
    String url;

    public Lecturers() {
    }

    public Lecturers(String name, String topic, String url) {
        this.name = name;
        this.topic = topic;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
