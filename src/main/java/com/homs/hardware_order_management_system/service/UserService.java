package com.homs.hardware_order_management_system.service;

import com.homs.hardware_order_management_system.dao.UserDAO;
import com.homs.hardware_order_management_system.dao.jdbc.UserJDBCDAO;
import com.homs.hardware_order_management_system.dto.LoginRequestDTO;
import com.homs.hardware_order_management_system.dto.UserSearchRequestDTO;
import com.homs.hardware_order_management_system.model.User;
import com.homs.hardware_order_management_system.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserJDBCDAO userJDBCDAO;

    //check login
    public UserDTO loggedUser(LoginRequestDTO loginRequestDTO){
        User user = this.userDAO.findByUserNameAndUserPassword(loginRequestDTO.getUserName(),loginRequestDTO.getPassWord());

        UserDTO userDTO = null;

        if (user!=null){
            userDTO = new UserDTO(user);
        }
        return userDTO;
    }

    //check login via jdbc
    public UserDTO loggedUserJDBC(LoginRequestDTO loginRequestDTO){
        UserDTO loggedUser = this.userJDBCDAO.getLoggedUserJDBC(loginRequestDTO);


        if (loggedUser.getUserID()!=null){
           return loggedUser;
        }
        return null;

    }

    //save and update user
    public UserDTO saveAndUpdateUser(UserDTO userDTO){
        User existUser = null;
        if (userDTO.getUserID()!=null){
            existUser = userDAO.getUserByUserID(userDTO.getUserID());
        }else {
            existUser = new User();
        }

        existUser.setUserName(userDTO.getUserName());
        existUser.setUserPassword(userDTO.getUserPassword());
        existUser.setUserRole(userDTO.getUserRole());
        existUser.setUserStatus(userDTO.getUserStatus());

        this.userDAO.saveAndFlush(existUser);
        return new UserDTO(existUser);
    }

    //delete user
    public Boolean deleteUser(Integer userID) {
        User existingProduct = this.userDAO.getUserByUserID(userID);
        if (existingProduct!=null){
            userDAO.deleteById(userID);
            return true;
        }else {
            return false;
        }
    }



    //get all users
    public List<UserDTO> getAllUsersJdbc(UserSearchRequestDTO userSearchRequestDTO) {
            List<UserDTO> userDTOList = this.userJDBCDAO.getAllUsersJdbc(userSearchRequestDTO);
            return userDTOList;
        }


    public User getUserByID(Integer userID) {
        User user = this.userDAO.getUserByUserID(userID);
        return user;
    }
}
