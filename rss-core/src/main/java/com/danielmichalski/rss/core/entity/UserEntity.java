package com.danielmichalski.rss.core.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import com.danielmichalski.rss.core.annotation.UsernameUnique;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "web_user")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, message = "Name must be at least 3 characters!")
    @Column(unique = true)
    @UsernameUnique(message = "Such username already exists")
    private String name;

    @Email(message = "Invalid e-mail address!")
    @Size(min = 3, message = "E-mail must be at least 3 characters!")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters!")
    private String password;

    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "web_user_x_user_role")
    private List<UserRoleEntity> roleEntities;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE)
    private List<RssFeedEntity> blogEntities;

    @ManyToOne
    private CountryEntity countryEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(List<UserRoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public List<RssFeedEntity> getBlogEntities() {
        return blogEntities;
    }

    public void setBlogEntities(List<RssFeedEntity> blogEntities) {
        this.blogEntities = blogEntities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roleEntities=" + roleEntities +
                ", blogEntities=" + blogEntities +
                ", countryEntity=" + countryEntity +
                '}';
    }
}
