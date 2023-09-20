package com.projet.gardenspringreact.restcontrollers;

import com.projet.gardenspringreact.entities.Post;
import com.projet.gardenspringreact.entities.User;
import com.projet.gardenspringreact.repositories.PostRepository;
import com.projet.gardenspringreact.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PostController {

    private PostService postService;

    public PostController(PostRepository postRepository) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/allposts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/createpost")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @PostMapping("/updatepost/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        postService.updatePost(id, updatedPost);
    }

    @PostMapping("/deletepost/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PostMapping("/deleteallposts")
    public void deleteAllPosts() {
        postService.deleteAllPosts();
    }
}
