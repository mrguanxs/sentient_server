package com.hoe.sentient.sync.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author guan
 * @date 2023/6/14
 */
@DS("oracle")
@Mapper
public interface SyncDataSelectMapper extends BaseMapper {

    @Select("SELECT * FROM ${tableName} WHERE ROWNUM > ((${page}-1) * ${pageSize}) AND ROWNUM <= (${page} * ${pageSize}) ")
    List<Map<String, Object>> getData(@Param("tableName") String tableName, @Param("page") Integer page, @Param("pageSize") Integer pageSize);
}
