package com.vassoler.crud.services;

import com.vassoler.crud.models.UserModel;
import com.vassoler.crud.repositorys.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.vassoler.crud.utils.PasswordHash.hashPassword;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public UserModel save(UserModel user) {
        var userModel = new UserModel();
        var passwordHash = hashPassword(user.getPassword());

        userModel.setPassword(passwordHash);
        userModel.setEmail(user.getEmail());
        userModel.setUsername(user.getUsername());

        return  userRepository.save(userModel);
    }

    @Transactional
    public UserModel updateUser(UUID id, UserModel user) {
        UserModel currentUser = getUserById(id);

        if (currentUser != null) {
            var passwordHash = hashPassword(user.getPassword());

            currentUser.setUsername(user.getUsername());
            currentUser.setPassword(passwordHash);
            currentUser.setEmail(user.getEmail());

           return userRepository.save(currentUser);
        }

        return user;
    }

    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
