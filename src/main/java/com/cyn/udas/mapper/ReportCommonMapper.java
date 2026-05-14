package com.cyn.udas.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ReportCommonMapper {

    void executeCreateTable(@Param("sql") String sql);

    List<Map<String,Object>> selectDynamicDataList(@Param("tableName") String tableName,
                                                   @Param("whereSql") String whereSql,
                                                   @Param("offset") Integer offset,
                                                   @Param("pageSize") Integer pageSize);

    int selectDynamicDataCount(@Param("tableName") String tableName,
                               @Param("whereSql") String whereSql);

    void dynamicLogicDelete(@Param("tableName") String tableName,
                            @Param("id") Long id,
                            @Param("updateBy") String updateBy);
}
