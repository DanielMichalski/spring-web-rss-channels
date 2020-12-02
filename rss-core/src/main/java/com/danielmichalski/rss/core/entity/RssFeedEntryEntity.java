package com.danielmichalski.rss.core.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "rss_feed_entry")
public class RssFeedEntryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1000)
    private String title;

    @Lob
    @Column(length = 10000)
    private String description;

    @Column(name = "published_date")
    private Date publishedDate;

    private String link;

    @ManyToOne
    private RssFeedEntity rssFeedEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public RssFeedEntity getRssFeedEntity() {
        return rssFeedEntity;
    }

    public void setRssFeedEntity(RssFeedEntity rssFeedEntity) {
        this.rssFeedEntity = rssFeedEntity;
    }

    @Override
    public String toString() {
        return "RssFeedEntryEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                ", link='" + link + '\'' +
                ", rssFeedEntity=" + rssFeedEntity +
                '}';
    }
}
