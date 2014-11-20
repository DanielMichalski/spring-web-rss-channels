package pl.dmichalski.agregator.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Daniel
 */
@Entity
public class Item {

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
    private Blog blog;

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

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
