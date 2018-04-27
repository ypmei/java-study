package hello.mapper;

import hello.bean.Hello;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HelloMapper {

    @Select("select * from user where name = #{name}")
    public List<Hello> likeName(String name);

    @Select("select * from user where id = #{id}")
    public List<Hello> getNameById(long id);
}
