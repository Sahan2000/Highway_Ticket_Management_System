package lk.gdse.userservice.service;

import lk.gdse.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    UserDTO getUser(String userId);
    List<UserDTO> getAllUsers();
    boolean isUserExists(String userId);

    String login(String username, String password);
    String generateUserId();
}
