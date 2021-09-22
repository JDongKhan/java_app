package com.jd.dao.mapper;

import java.util.List;
import java.util.Map;


import com.jd.dao.beans.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {


    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @Select("select * from t_user where user_account=#{ua} and user_password=#{pw}")
    @Results({

            @Result(id = true, property = "user_id", column = "user_id", javaType = Integer.class),
            @Result(property = "user_name", column = "user_name", javaType = String.class),
            @Result(property = "user_password", column = "user_password", javaType = String.class),
            @Result(property = "user_account", column = "user_account", javaType = String.class),
            @Result(property = "isAdmin", column = "isAdmin", javaType = Integer.class)
    })
    public UserBean login(@Param("ua") String userAccount, @Param("pw") String password) throws Exception;


    /**
     * 添加用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into t_user (user_account,user_name,user_password,user_phone) value (#{user.user_account},#{user.user_name},#{user.user_password},#{user.user_phone})")
    @Options(useGeneratedKeys = true, keyProperty = "user.user_id")
    public int insertUser(@Param("user") UserBean user) throws Exception;


    /**
     * 更新用户
     *
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser(UserBean user) throws Exception;

    /**
     * 删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Delete(" update t_user set user_status = 1 where user_id=#{id}  ")
    public int deleteUser(int id) throws Exception;


    /**
     * 根据ID查询用户
     *
     * @param user_account
     * @return
     * @throws Exception
     */

    @Select(" select * from t_user where user_account=#{ua}")
    @Results({

            @Result(id = true, property = "user_id", column = "user_id", javaType = Integer.class),
            @Result(property = "user_name", column = "user_name", javaType = String.class),
            @Result(property = "user_password", column = "user_password", javaType = String.class),
            @Result(property = "user_account", column = "user_account", javaType = String.class)
    })
    public UserBean queryByAccount(@Param("ua") String user_account) throws Exception;

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     * @throws Exception
     */

    @Select(" select * from t_user where user_id=#{id}")
    @Results({

            @Result(id = true, property = "user_id", column = "user_id", javaType = Integer.class),
            @Result(property = "user_name", column = "user_name", javaType = String.class),
            @Result(property = "user_password", column = "user_password", javaType = String.class),
            @Result(property = "user_account", column = "user_account", javaType = String.class)
    })
    public UserBean queryUserById(int id) throws Exception;

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */

    @Select(" select * from t_user")
    @ResultMap("userMap")
    public List<UserBean> queryAllUser() throws Exception;


    /**
     * 整体插入一组用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    public int batchInsertUser(@Param("users") List<UserBean> user) throws Exception;

    /**
     * 整体删除一组用户
     *
     * @param list
     * @return
     * @throws Exception
     */
    public int batchDeleteUser(@Param("list") List<Integer> list) throws Exception;


    /**
     * 分页查询用户
     *
     * @param parma
     * @return
     * @throws Exception
     */
    public List<UserBean> pagerUser(Map<String, Object> parmas) throws Exception;

    /**
     * 查询用户
     *
     * @param parma
     * @return
     * @throws Exception
     */
    public int countUser(Map<String, Object> parmas) throws Exception;


}
