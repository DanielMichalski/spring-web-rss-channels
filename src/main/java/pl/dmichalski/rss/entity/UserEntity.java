package pl.dmichalski.rss.entity;

import org.hibernate.validator.constraints.Email;
import pl.dmichalski.rss.annotation.UsernameUnique;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

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
    @JoinTable(name = "web_user_x_web_user_role")
    private List<RoleEntity> roleEntities;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE)
    private List<BlogEntity> blogEntities;

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

    public List<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(List<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public List<BlogEntity> getBlogEntities() {
        return blogEntities;
    }

    public void setBlogEntities(List<BlogEntity> blogEntities) {
        this.blogEntities = blogEntities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
