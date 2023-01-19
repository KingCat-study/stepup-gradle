package com.jh.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterTestMethod
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    void post를_저장조회한다() {
        //given
        String title = "title";
        String content = "content";
        Posts savePost = Posts.builder()
                        .title(title)
                        .content(content)
                        .author("tester")
                        .build();

        //when
        postsRepository.save(savePost);
        List<Posts> posts = postsRepository.findAll();

        //then
        Posts post = posts.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    void BaseTimeEntity_등록() {

        //given
        LocalDateTime now = LocalDateTime.of(2022,5,24,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0);

        System.out.println(" --------- createDate=" + posts.getCreatedDate());
        System.out.println(" --------- modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}