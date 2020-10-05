package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    String content;
    @Enumerated(EnumType.STRING)
    Status status = Status.DRAFT;
    LocalDateTime createdAt;
    @Transient
    String excludeColumn;

    static enum Status{DRAFT, PUBLISHED}

    public static Post of(String title, String content) {
        Post post = new Post();
        post.setCreatedAt(LocalDateTime.now());
        post.setTitle(title);
        post.setContent(content);

        return post;
    }
}
