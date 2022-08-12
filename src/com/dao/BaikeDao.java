package com.dao;

import com.pojo.Baike;
import com.pojo.BaikeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaikeDao {
    int countByExample(BaikeQuery example);

    int deleteByExample(BaikeQuery example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Baike record);

    int insertSelective(Baike record);

    List<Baike> selectByExample(BaikeQuery example);

    Baike selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Baike record, @Param("example") BaikeQuery example);

    int updateByExample(@Param("record") Baike record, @Param("example") BaikeQuery example);

    int updateByPrimaryKeySelective(Baike record);

    int updateByPrimaryKey(Baike record);
}