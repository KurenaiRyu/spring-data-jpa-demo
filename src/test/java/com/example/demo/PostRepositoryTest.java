package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "logging.level.trace")
class PostRepositoryTest {

    @Autowired
    private PostRepository repository;

    @Test
    void testPostRepository() {
        Post post = Post.of("Test Post", "Testing!");
        repository.save(post);
        assertEquals(repository.findById(post.getId()).get().getTitle(), post.getTitle());

        List<Post> postList = repository.findAll();
        System.out.println(postList);

        System.out.println(repository.findAll((Specification<Post>) (root, criteriaQuery, builder) -> builder.like(root.get(Post_.title), "%Test%")));
    }
}