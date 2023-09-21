package com.projet.gardenspringreact.services;

import com.projet.gardenspringreact.entities.Comment;
import com.projet.gardenspringreact.entities.Post;
import com.projet.gardenspringreact.repositories.CommentRepository;
import com.projet.gardenspringreact.repositories.PostRepository;
import com.projet.gardenspringreact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Le commentaire n'existe pas."));
    }

    public List<Comment> getAllCommentsByPostId(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            return commentRepository.findByPost(post);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le post n'existe pas.");
        }
    }

    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, Comment updatedComment) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();

            comment.setText(updatedComment.getText());

            return commentRepository.save(comment);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le commentaire n'existe pas ");
        }
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vous ne pouvez pas supprimer ce commentaire"));
        commentRepository.delete(comment);
    }

    public void deleteAllComments() {
        commentRepository.deleteAll();
    }

}

