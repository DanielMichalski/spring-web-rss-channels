package pl.dmichalski.rss.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Author: Daniel
 */
@Entity
@Table
public class BlogEntity {

    @Id
    @GeneratedValue
    private Long id;

    @URL(message = "Invalid URL!")
    @Size(min = 1, message = "Invalid URL!")
    @Column(length = 1000)
    private String url;

    @Size(min = 1, message = "Name must be at least 1 character!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "blogEntity", cascade = CascadeType.REMOVE)
    private List<BlogEntryEntity> itemEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<BlogEntryEntity> getItemEntities() {
        return itemEntities;
    }

    public void setItemEntities(List<BlogEntryEntity> itemEntities) {
        this.itemEntities = itemEntities;
    }
}
