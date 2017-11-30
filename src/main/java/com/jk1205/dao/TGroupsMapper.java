package com.jk1205.dao;

import com.jk1205.pojo.TGroups;
import com.jk1205.pojo.TGroupsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGroupsMapper {
    int countByExample(TGroupsExample example);

    int deleteByExample(TGroupsExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(TGroups record);

    int insertSelective(TGroups record);

    List<TGroups> selectByExample(TGroupsExample example);

    TGroups selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") TGroups record, @Param("example") TGroupsExample example);

    int updateByExample(@Param("record") TGroups record, @Param("example") TGroupsExample example);

    int updateByPrimaryKeySelective(TGroups record);

    int updateByPrimaryKey(TGroups record);
}