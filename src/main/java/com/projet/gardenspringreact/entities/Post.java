package com.projet.gardenspringreact.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoVideo;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "likedPosts")
    private Set<User> likes = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String photoVideo, String description, User user, Set<User> likes, List<Comment> comments) {
        this.photoVideo = photoVideo;
        this.description = description;
        this.user = user;
        this.likes = likes;
        this.comments = comments;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoVideo() {
        return photoVideo;
    }

    public void setPhotoVideo(String photoVideo) {
        this.photoVideo = photoVideo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
