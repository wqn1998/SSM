package com.dao;

import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyuserDao {
    int countByExample(MyuserQuery example);

    int deleteByExample(MyuserQuery example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Myuser record);

    int insertSelective(Myuser record);

    List<Myuser> selectByExample(MyuserQuery example);

    Myuser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Myuser record, @Param("example") MyuserQuery example);

    int updateByExample(@Param("record") Myuser record, @Param("example") MyuserQuery example);

    int updateByPrimaryKeySelective(Myuser record);

    int updateByPrimaryKey(Myuser record);
}