package com.Workit.Workit.controller;

import com.Workit.Workit.model.Post;
import com.Workit.Workit.repo.PostRepo;
import com.Workit.Workit.repo.SearchRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PostController {
    @Autowired
    SearchRepoImpl searchRepo;
    @Autowired
    PostRepo postRepo;
    @GetMapping("/posts")
    @CrossOrigin
    public List<Post> getAllPost(){
        System.out.println("POSTS FETCHED");
        return postRepo.findAll();
    }
    @GetMapping("/searchPosts/{text}")
    @CrossOrigin
    public List<Post> searchPost(@PathVariable("text") String text){
        return searchRepo.findByText(text);
    }


    @PostMapping("/newPost")
    @CrossOrigin
    public Post addPost(@RequestBody Post post){
        System.out.println("POST CREATED");
       return postRepo.save(post);
    }
}
