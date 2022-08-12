package com.dao;

import com.pojo.Yuyue;
import com.pojo.YuyueQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YuyueDao {
    int countByExample(YuyueQuery example);

    int deleteByExample(YuyueQuery example);

    int deleteByPrimaryKey(Integer yid);

    int insert(Yuyue record);

    int insertSelective(Yuyue record);

    List<Yuyue> selectByExample(YuyueQuery example);

    Yuyue selectByPrimaryKey(Integer yid);

    int updateByExampleSelective(@Param("record") Yuyue record, @Param("example") YuyueQuery example);

    int updateByExample(@Param("record") Yuyue record, @Param("example") YuyueQuery example);

    int updateByPrimaryKeySelective(Yuyue record);

    int updateByPrimaryKey(Yuyue record);
}