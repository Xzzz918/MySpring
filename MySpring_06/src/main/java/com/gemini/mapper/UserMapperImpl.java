package com.gemini.mapper;

import com.gemini.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author gemini
 * Created in  2021/5/5 10:50
 */
public class UserMapperImpl implements UserMapper {

    //原来我们的所有操作都使用SQLSession来执行，现在使用SqlSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
