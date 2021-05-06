package com.gemini.mapper;

import com.gemini.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gemini
 * Created in  2021/5/5 10:12
 */
public interface UserMapper {
    List<User> selectUser();

    //Add a User
    int addUser(User user);
    //delete a User
    int deleteUser(@Param("id") int id);
}
