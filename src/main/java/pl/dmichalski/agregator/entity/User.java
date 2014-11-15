package pl.dmichalski.agregator.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Author: Daniel
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, message = "Name must be at least 3 characters!")
    private String name;

    @Email(message = "Invalid e-mail address!")
    @Size(min = 3, message = "E-mail must be at least 3 characters!")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters!")
    private String password;

    private boolean enabled;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Blog> blogs;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
