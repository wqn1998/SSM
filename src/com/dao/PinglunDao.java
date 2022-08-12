package com.dao;

import com.pojo.Pinglun;
import com.pojo.PinglunQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PinglunDao {
    int countByExample(PinglunQuery example);

    int deleteByExample(PinglunQuery example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Pinglun record);

    int insertSelective(Pinglun record);

    List<Pinglun> selectByExample(PinglunQuery example);

    Pinglun selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Pinglun record, @Param("example") PinglunQuery example);

    int updateByExample(@Param("record") Pinglun record, @Param("example") PinglunQuery example);

    int updateByPrimaryKeySelective(Pinglun record);

    int updateByPrimaryKey(Pinglun record);
}