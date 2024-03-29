package com.jh.web;

import com.jh.config.auth.LoginUser;
import com.jh.config.auth.dto.SessionUser;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jh.service.PostsService;
import com.jh.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(
        @PathVariable Long id, 
        Model model) {
        
            PostsResponseDto responseDto = postsService.findById(id);
            model.addAttribute("post", responseDto);

        return "posts-update";
    }
}
