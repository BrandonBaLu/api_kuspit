package com.itf.kuspit.services;

import com.itf.kuspit.models.UserModel;
import com.itf.kuspit.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(Long id) {

        return userRepository.findById(id);
    }

    /*public UserModel updateUser(UserModel request, Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel updatedUser = user.get();
            updatedUser.setNombre(request.getNombre());
            updatedUser.setApellido(request.getApellido());
            updatedUser.setEmail(request.getEmail());
            updatedUser.setPassword(request.getPassword());
            updatedUser.setPhone(request.getPhone());
            return userRepository.save(updatedUser);
        }
        return null;
    }*/

    public UserModel updateById(UserModel request, Long id) {
        UserModel user = userRepository.findById(id).get();

        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setEmail(request.getEmail());
        user.setPassword(request.getContrasena());
        user.setPhone(request.getPhone());

        //return userRepository.save(user);
        return user;
    }

    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
