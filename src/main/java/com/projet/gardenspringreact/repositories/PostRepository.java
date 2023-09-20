package com.projet.gardenspringreact.repositories;

import com.projet.gardenspringreact.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
