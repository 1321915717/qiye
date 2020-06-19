package com.zyc.qiye.mapper;


import com.zyc.qiye.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select * from user where user_name=#{username}")
    User findByUserName(@Param("username") String username);

    @Select("select * from user where u_id=#{id} ")
    User fidById(@Param("id") int id);


    @Select("select * from user where user_name=#{name} and password=#{password}")
    User findByNameAndPwd(@Param("name") String name, @Param("password") String password);


    @Update( "update  user  set  user_name=#{name},password=#{pwd} where  u_id=1")
     int  update(@Param("name")String name,@Param("pwd")String pwd);

}
