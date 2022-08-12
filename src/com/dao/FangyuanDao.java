package com.dao;

import com.pojo.Fangyuan;
import com.pojo.FangyuanQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FangyuanDao {
    int countByExample(FangyuanQuery example);

    int deleteByExample(FangyuanQuery example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Fangyuan record);

    int insertSelective(Fangyuan record);

    List<Fangyuan> selectByExample(FangyuanQuery example);

    Fangyuan selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Fangyuan record, @Param("example") FangyuanQuery example);

    int updateByExample(@Param("record") Fangyuan record, @Param("example") FangyuanQuery example);

    int updateByPrimaryKeySelective(Fangyuan record);

    int updateByPrimaryKey(Fangyuan record);
}