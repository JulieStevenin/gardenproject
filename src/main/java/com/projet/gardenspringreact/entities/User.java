package com.projet.gardenspringreact.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String fname;
    private String lname;
    private String password;
    private String avatar;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_likes_post",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private Set<Post> likedPosts = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String fname, String lname, String password, String avatar, Set<Post> likedPosts, List<Post> posts) {
        this.username = username;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.avatar = avatar;
        this.likedPosts = likedPosts;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
