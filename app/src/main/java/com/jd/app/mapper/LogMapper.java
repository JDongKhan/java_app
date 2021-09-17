package com.jd.app.mapper;

import com.jd.app.beans.LogBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LogMapper {


    /**
     * 添加用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into t_operation_log (log_message,log_time,log_user_name,version) value (#{log.log_message},#{log.log_time},#{log.log_user_name},#{log.version})")
    @Options(useGeneratedKeys = true, keyProperty = "log.log_id")
    public int insertLog(@Param("log") LogBean log);


    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */

    @Select(" select * from t_operation_log where version = #{version} order by log_time desc limit 0, 100 ")
    @ResultMap("logMap")
    public List<LogBean> selectAllLog(@Param("version") String version);

}
