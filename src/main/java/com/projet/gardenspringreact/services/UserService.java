package com.projet.gardenspringreact.services;

import com.projet.gardenspringreact.entities.Post;
import com.projet.gardenspringreact.entities.User;
import com.projet.gardenspringreact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setFname(updatedUser.getFname());
            existingUser.setLname(updatedUser.getLname());
            existingUser.setAvatar(updatedUser.getAvatar());
            userRepository.save(existingUser);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void likePost(User user, Post post) {
        if (user != null && post != null) {
            user.getLikedPosts().add(post);
            userRepository.save(user);
        }
    }

        public User registerUser(User user) {
            if (userRepository.findByUsername(user.getUsername()) != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le nom d'utilisateur est déjà utilisé.");
            }
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'adresse e-mail est est déjà utilisée.");
            }
            return userRepository.save(user);
        }


    public User loginUser(String username, String password) {

        User user = userRepository.findByUsername(username);

        if (user == null) {

            return null;
        }

        if (password.equals(user.getPassword())) {

            return user;
        } else {

            return null;
        }
    }
}