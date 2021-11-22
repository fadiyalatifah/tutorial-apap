package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getUserList();
    UserModel getUserByUsername(String username);
    UserModel getUserByEmail(String email);
    void deleteUser(UserModel user);
    void updatePassword(UserModel user, String password);
    boolean checkMatch(String oldPassword, String newPassword);
}