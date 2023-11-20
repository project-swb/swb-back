package com.swb.web;

import com.swb.config.auth.LoginUser;
import com.swb.config.auth.dto.SessionUser;
import com.swb.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.swb.service.posts.PostsService;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        System.out.println(user);
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "page/index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "page/posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "page/posts-update";
    }



}
