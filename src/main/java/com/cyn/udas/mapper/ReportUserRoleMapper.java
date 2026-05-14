package com.cyn.udas.mapper;

import com.cyn.udas.entity.ReportUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReportUserRoleMapper {

    int insert(ReportUserRole userRole);

    ReportUserRole getByReportAndAccount(@Param("reportCode") String reportCode,
                                         @Param("account") String account);
}
