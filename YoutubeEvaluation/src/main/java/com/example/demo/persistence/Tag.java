package com.example.demo.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column(nullable = false)
    @NotNull
    private String name;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
