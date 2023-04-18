package com.homs.hardware_order_management_system.dao.jdbc;

import com.homs.hardware_order_management_system.dto.LoginRequestDTO;
import com.homs.hardware_order_management_system.dto.UserSearchRequestDTO;
import com.homs.hardware_order_management_system.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserJDBCDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDTO getLoggedUserJDBC(LoginRequestDTO loginRequestDTO) {
        UserDTO loggedUser = new UserDTO();
        Map<String,Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT																						\n");
        SQL.append("    *																						\n");
        SQL.append("FROM																						\n");
        SQL.append("    user_table ut																			\n");
        SQL.append("WHERE																						\n");
        SQL.append("    ut.user_status = \"ACTIVE\" AND ut.user_name = \""+loginRequestDTO.getUserName()+"\" AND ut.user_password = \""+loginRequestDTO.getPassWord()+"\";	\n");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<UserDTO>() {
            @Override
            public UserDTO extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {
                    loggedUser.setUserID(rs.getInt("user_id"));
                    loggedUser.setUserName(rs.getString("user_name"));
                    loggedUser.setUserPassword(rs.getString("user_password"));
                    loggedUser.setUserRole(rs.getString("user_role"));
                    loggedUser.setUserStatus(rs.getString("user_status"));
                }
                return loggedUser;
            }
        });
    }

    public List<UserDTO> getAllUsersJdbc(UserSearchRequestDTO userSearchRequestDTO) {
        List<UserDTO> result = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        StringBuilder SQL = new StringBuilder();
        SQL.append("SELECT								\n");
        SQL.append("    ut.user_id,						\n");
        SQL.append("    ut.user_name,					\n");
        SQL.append("    ut.user_password,				\n");
        SQL.append("    ut.user_role,   				\n");
        SQL.append("    ut.user_status					\n");
        SQL.append("FROM								\n");
        SQL.append("    user_table ut					\n");
        SQL.append("WHERE								\n");
        SQL.append("    ut.user_id IS NOT NULL 		\n");

        if (userSearchRequestDTO.getUserName()!=null && !userSearchRequestDTO.getUserName().equals("")){
            SQL.append("   AND ut.user_name LIKE '%"+userSearchRequestDTO.getUserName()+"%' 	\n");
        }

        if (userSearchRequestDTO.getUserRole()!=null && !userSearchRequestDTO.getUserRole().equals("")){
            SQL.append("   AND ut.user_role LIKE '%"+userSearchRequestDTO.getUserRole()+"%' 	\n");
        }

        if (userSearchRequestDTO.getUserStatus()!=null && !userSearchRequestDTO.getUserStatus().equals("")){
            SQL.append("  AND  ut.user_status = \""+userSearchRequestDTO.getUserStatus()+"\"		\n");
        }

        return namedParameterJdbcTemplate.query(SQL.toString(), params, new ResultSetExtractor<List<UserDTO>>() {
            @Override
            public List<UserDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<UserDTO> result = new ArrayList<>();

                while (rs.next()){
                    UserDTO newUser = new UserDTO();
                    newUser.setUserID(rs.getInt("user_id"));
                    newUser.setUserName(rs.getString("user_name"));
                    newUser.setUserPassword(rs.getString("user_password"));
                    newUser.setUserRole(rs.getString("user_role"));
                    newUser.setUserStatus(rs.getString("user_status"));

                    result.add(newUser);
                }


                return result;
            }
        });


    }
}
