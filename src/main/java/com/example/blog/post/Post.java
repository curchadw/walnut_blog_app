package com.example.blog.post;

import org.springframework.http.ResponseEntity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post{

    @Id
    @GeneratedValue
    private Long id;
    private Boolean success;


    private String tag;






    public Post() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public String getTag() {
        return tag;
    }


}
