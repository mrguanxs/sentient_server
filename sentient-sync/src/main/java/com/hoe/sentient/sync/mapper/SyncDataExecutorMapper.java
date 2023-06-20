package com.hoe.sentient.sync.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guan
 * @date 2023/6/14
 */
@Mapper
public interface SyncDataExecutorMapper extends BaseMapper {

    /**
     * 根据MAP插入数据
     *
     * @param tableName
     * @param dataMap
     * @return
     */
    boolean insertData(@Param("tableName") String tableName, @Param("dataMap") Map<String, Object> dataMap);

    /**
     * 批量插入
     * @param tableName
     * @param mapList
     * @return
     */
    boolean batchInsertData(@Param("tableName") String tableName, @Param("mapList") List<Map<String, Object>> mapList);

    /**
     * 删除
     * @param tableName
     * @param fieldName
     * @param fieldValue
     */
    void deleteByField(@Param("tableName") String tableName, @Param("fieldName") String fieldName, @Param("fieldValue") Object fieldValue);

    /**
     * 批量删除
     * @param tableName
     * @param fieldName
     * @param fieldValueList
     */
    void batchDeleteByField(@Param("tableName") String tableName, @Param("fieldName") String fieldName, @Param("fieldValueList") List<Object> fieldValueList);
}
