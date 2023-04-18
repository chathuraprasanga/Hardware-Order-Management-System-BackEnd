package com.homs.hardware_order_management_system.controller;

import com.homs.hardware_order_management_system.dto.LoginRequestDTO;
import com.homs.hardware_order_management_system.dto.UserSearchRequestDTO;
import com.homs.hardware_order_management_system.model.User;
import com.homs.hardware_order_management_system.model.dto.UserDTO;
import com.homs.hardware_order_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    //check login
    @PostMapping(value = "/get-logged-user")
    public ResponseEntity<UserDTO> loggedUser(@RequestBody LoginRequestDTO loginRequestDTO){
        UserDTO userDTO = this.userService.loggedUserJDBC(loginRequestDTO);

        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    //save and update user
    @PostMapping(value = "save-and-update-user")
    public ResponseEntity<UserDTO> saveAndUpdateUser(@RequestBody UserDTO userDTO){
        UserDTO newUser = this.userService.saveAndUpdateUser(userDTO);
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }

    //delete userID
    @DeleteMapping(value = "/delete-user/{userID}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer userID){
        Boolean result = this.userService.deleteUser(userID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    //get all Users jdbc
    @RequestMapping(value = "/get-all-users-jdbc", method = RequestMethod.POST)
    public  ResponseEntity<List<UserDTO>> getAllUsersWithSearch(@RequestBody UserSearchRequestDTO userSearchRequestDTO){
        List<UserDTO> userDTOList = this.userService.getAllUsersJdbc(userSearchRequestDTO);
        return new ResponseEntity<>(userDTOList,HttpStatus.OK);
    }

    //search userId by id
    @GetMapping(value = "/get-user-by-id/{userID}")
    public ResponseEntity<User> getUserByID(@PathVariable Integer userID){
        User user = this.userService.getUserByID(userID);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
