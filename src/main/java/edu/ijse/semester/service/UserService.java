package edu.ijse.semester.service;

import edu.ijse.semester.dto.UserDTO;

import java.util.List;

public interface UserService {
    public void saveUser(UserDTO userDTO);
    public void deleteUser(String id);
    public void updateUser(UserDTO userDTO);
    public UserDTO searchUser(String id);
    public List<UserDTO> getAllUser();
}
