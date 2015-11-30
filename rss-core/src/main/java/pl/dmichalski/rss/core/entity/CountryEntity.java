package pl.dmichalski.rss.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "country_name", length = 100)
    private String contryName;

    @OneToMany(mappedBy = "countryEntity")
    private List<UserEntity> userEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContryName() {
        return contryName;
    }

    public void setContryName(String name) {
        this.contryName = name;
    }

    public List<UserEntity> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(List<UserEntity> userEntity) {
        this.userEntity = userEntity;
    }
}
