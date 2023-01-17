package com.jh.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterAll
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    void post를_저장조회한다() {
        String title = "title";
        String content = "content";
        Posts post = Posts.builder()
                        .title(title)
                        .content(content)
                        .author("tester")
                    .build();

        postsRepository.save(post);
        postsRepository.findAll();

    }
}