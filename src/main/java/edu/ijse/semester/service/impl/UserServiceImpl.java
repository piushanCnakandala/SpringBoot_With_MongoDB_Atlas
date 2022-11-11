package edu.ijse.semester.service.impl;

import edu.ijse.semester.dto.UserDTO;
import edu.ijse.semester.entity.User;
import edu.ijse.semester.repo.UserRepo;
import edu.ijse.semester.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        if (!repo.existsById(userDTO.getId())){
            repo.save(mapper.map(userDTO, User.class));
        }else {
            throw new RuntimeException("Customer Already exist....");
        }
    }

    @Override
    public void deleteUser(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("please Check the customer id");
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (repo.existsById(userDTO.getId())){
            repo.save(mapper.map(userDTO,User.class));
        }else {
            throw new RuntimeException("No Such User To Update");
        }
    }

    @Override
    public UserDTO searchUser(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id).get(),UserDTO.class);
        }else {
            throw new RuntimeException("No User for "+id+" ...!");
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        return mapper.map(repo.findAll(),new TypeToken<List<UserDTO>>(){}.getType());
    }
}
