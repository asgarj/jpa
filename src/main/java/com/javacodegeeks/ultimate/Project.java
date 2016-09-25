package com.javacodegeeks.ultimate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asgar on 9/25/16.
 */

@Entity
@Table(name = "T_PROJECT")
public class Project {
    private Long id;
    private String title;
    private List<Geek> geeks = new ArrayList<>();
    private Period projectPeriod;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany
    @JoinTable(
            name="T_GEEK_PROJECT",
            joinColumns={@JoinColumn(name="PROJECT_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="GEEK_ID", referencedColumnName="ID")})
    public List<Geek> getGeeks() {
        return geeks;
    }

    public void setGeeks(List<Geek> geeks) {
        this.geeks = geeks;
    }

    @Embedded
    public Period getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(Period projectPeriod) {
        this.projectPeriod = projectPeriod;
    }
}
