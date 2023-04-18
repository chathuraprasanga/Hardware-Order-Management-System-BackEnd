package com.homs.hardware_order_management_system.dao;

import com.homs.hardware_order_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUserNameAndUserPassword(String userName, String userPassword);

    User getUserByUserID(Integer userID);

}
