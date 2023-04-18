package com.homs.hardware_order_management_system.model.dto;

import com.homs.hardware_order_management_system.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UserDTO {

    private Integer userID;
    private String userName;
    private String userPassword;
    private String userRole;
    private String userStatus;

    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.userRole = user.getUserRole();
        this.userStatus = user.getUserStatus();
    }
}
