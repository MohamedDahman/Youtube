package com.example.demo.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TestVideo {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    public TestVideo(String name) {
        this.name = name;
    }

    public TestVideo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestVideo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

