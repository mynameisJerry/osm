package com.pzhu.shopping.myshop.mapper;

import com.pzhu.shopping.myshop.pojo.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jackiechan on 10/16/18/6:44 PM
 *
 * @Author jackiechan
 */
@Repository
public interface UserMapper {

    void addUser(User user);

    int checkUserName(String username);

    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    void modifyPwd(User user);

    List<User> findAllUser(@Param("username") String username, @Param("gender") String gender);

    List<User> getUserList();

    void delete(int userid);

    String findUserNameById(int uid);

    Integer getIdByUsername(String username);

    List<User> getInvalidUserList();

    String getPasswordSaltByUsername(String username);

    int updateUser(User user);
}
