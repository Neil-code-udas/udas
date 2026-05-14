package com.cyn.udas.mapper;


import com.cyn.udas.entity.ReportDef;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportDefMapper {

    int insert(ReportDef reportDef);

    ReportDef getByReportCode(@Param("reportCode") String reportCode);

    List<ReportDef> selectReportList(@Param("reportName") String reportName,
                                     @Param("offset") Integer offset,
                                     @Param("pageSize") Integer pageSize);

    int selectReportCount(@Param("reportName") String reportName);
}
