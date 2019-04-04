package com.zyx.course.mapper;

import com.zyx.course.eo.eo.DataVo;
import com.zyx.course.eo.eo.UserEo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LeaveUserMapper {
    @Select("SELECT * FROM user WHERE `user`.role=#{eo.role} and dr=0")
    List<DataVo> selectUserList(@Param("eo") UserEo eo);

    @Update("UPDATE user  SET `user`.dr=1 AND `user`.id= #{id}")
    void deleteUserById(@Param("id") Integer id);

    @Insert("INSERT INTO user (`user`.userName,`user`.number,`user`.`passWord`,`user`.createTime,`user`.role) VALUES(#{eo.userName},#{eo.number},#{eo.passWord},now(),#{eo.role})")
    void insertAdminOrTeacher(@Param("eo") UserEo eo);

    @Insert("INSERT INTO user (`user`.userName,`user`.number,`user`.`passWord`,`user`.createTime,`user`.role,`user`.college,`user`.grade,`user`.clas) VALUES()")
    void insertStudent(@Param("eo") UserEo eo);

    @Insert("INSERT INTO user (`user`.userName,`user`.number,`user`.`passWord`,`user`.createTime,`user`.role,`user`.college) VALUES()")
    void insertLeader(@Param("eo") UserEo eo);

    @Insert("INSERT INTO user (`user`.userName,`user`.number,`user`.`passWord`,`user`.createTime,`user`.role,`user`.college,`user`.grade) VALUES()")
    void insertInstructor(@Param("eo") UserEo eo);

    @Update("UPDATE user SET `user`.`passWord`=#{eo.passWord} ,`user`.phone = #{eo.phone} WHERE user.id=#{eo.id} ")
    void updateUser(@Param("eo") UserEo eo);

    @Select("select * from user where passWord=#{eo.passWord} and number = #{eo.number} and dr=0")
    DataVo selectUserByLogin(@Param("eo") UserEo eo);

    @Select("select * from user where dr = 0 and number = #{number}")
    DataVo selectUserByNumber(@Param("number") Integer number);
}
