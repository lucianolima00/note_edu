package com.example.noteedu.user;

import com.example.noteedu.user.User;
import com.example.noteedu.user.UserRepository;
import com.example.noteedu.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service

public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("user with id "+ id + " does not exist"));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(Long id, String name, String email, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("user with id "+ id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            user.setEmail(email);
        }

        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("user with id "+ id + " does not exist"));

        userRepository.delete(user);
    }
}
