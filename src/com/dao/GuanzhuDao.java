package com.dao;

import com.pojo.Guanzhu;
import com.pojo.GuanzhuQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuanzhuDao {
    int countByExample(GuanzhuQuery example);

    int deleteByExample(GuanzhuQuery example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Guanzhu record);

    int insertSelective(Guanzhu record);

    List<Guanzhu> selectByExample(GuanzhuQuery example);

    Guanzhu selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Guanzhu record, @Param("example") GuanzhuQuery example);

    int updateByExample(@Param("record") Guanzhu record, @Param("example") GuanzhuQuery example);

    int updateByPrimaryKeySelective(Guanzhu record);

    int updateByPrimaryKey(Guanzhu record);
}