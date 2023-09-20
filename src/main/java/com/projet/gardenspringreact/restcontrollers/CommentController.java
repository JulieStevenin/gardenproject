package com.projet.gardenspringreact.restcontrollers;

import com.projet.gardenspringreact.entities.Comment;
import com.projet.gardenspringreact.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }
    @GetMapping("/comment/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @PostMapping("/createpost")
    public void createComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
    }

    @PostMapping ("/deletecomment/{id}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

    @PostMapping ("/deleteallcomments")
    public void deleteAllComments() {
        commentService.deleteAllComments();
    }
}

