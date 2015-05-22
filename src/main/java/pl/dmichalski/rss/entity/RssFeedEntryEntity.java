package pl.dmichalski.rss.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Daniel
 */
@Entity
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
        final StringBuilder sb = new StringBuilder("RssFeedEntryEntity{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", publishedDate=").append(publishedDate);
        sb.append(", link='").append(link).append('\'');
        sb.append(", rssFeedEntity=").append(rssFeedEntity);
        sb.append('}');
        return sb.toString();
    }

}
