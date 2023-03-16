package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;


    @CreationTimestamp
    private Date pubDate;

    @ManyToOne
    @JoinColumn
    User user;

   @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
   List<Image> imageList = new ArrayList<>();

    public Blog() {
    }

    public Blog(int id, String title, String content, Date pubDate, User user, List<Image> imageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
        this.imageList = imageList;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public User getUser() {
        return user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
