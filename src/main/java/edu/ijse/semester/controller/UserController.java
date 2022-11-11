package edu.ijse.semester.controller;

import edu.ijse.semester.dto.UserDTO;
import edu.ijse.semester.entity.User;
import edu.ijse.semester.repo.UserRepo;
import edu.ijse.semester.service.UserService;
import edu.ijse.semester.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@ModelAttribute UserDTO user){
        userService.saveUser(user);
        return  new ResponseUtil(200,"Save",null);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUser(){
        return new ResponseUtil(200,"ok",userService.getAllUser());

    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam String id){
        userService.deleteUser(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path ="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseUtil SearchUser(@PathVariable String id){
        return new ResponseUtil(200,"Deleted",userService.searchUser(id));

    }
}
