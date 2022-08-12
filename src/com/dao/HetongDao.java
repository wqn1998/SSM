package com.dao;

import com.pojo.Hetong;
import com.pojo.HetongQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HetongDao {
    int countByExample(HetongQuery example);

    int deleteByExample(HetongQuery example);

    int deleteByPrimaryKey(Integer hid);

    int insert(Hetong record);

    int insertSelective(Hetong record);

    List<Hetong> selectByExample(HetongQuery example);

    Hetong selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") Hetong record, @Param("example") HetongQuery example);

    int updateByExample(@Param("record") Hetong record, @Param("example") HetongQuery example);

    int updateByPrimaryKeySelective(Hetong record);

    int updateByPrimaryKey(Hetong record);
}