package com.gemini.mapper;

import com.gemini.pojo.User;

import java.util.List;

/**
 * @author gemini
 * Created in  2021/5/5 10:12
 */
public interface UserMapper {
    public List<User> selectUser();
}
