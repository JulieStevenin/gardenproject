package com.projet.gardenspringreact.services;

import com.projet.gardenspringreact.entities.Post;
import com.projet.gardenspringreact.entities.User;
import com.projet.gardenspringreact.repositories.PostRepository;
import com.projet.gardenspringreact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        } else {
            return null;
        }
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Long postId, Post updatedPost) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            existingPost.setPhotoVideo(updatedPost.getPhotoVideo());
            existingPost.setDescription(updatedPost.getDescription());

            postRepository.save(existingPost);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le post n'existe pas.");
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

}
