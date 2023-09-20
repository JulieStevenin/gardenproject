package com.projet.gardenspringreact.repositories;

import com.projet.gardenspringreact.entities.Comment;
import com.projet.gardenspringreact.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost (Post post);
}
