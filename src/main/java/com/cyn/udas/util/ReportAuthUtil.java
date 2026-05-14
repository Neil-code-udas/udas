package com.cyn.udas.util;


import com.cyn.udas.constant.ReportRoleConst;
import com.cyn.udas.constant.SysConstant;
import com.cyn.udas.entity.ReportUserRole;
import com.cyn.udas.mapper.ReportUserRoleMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ReportAuthUtil {

    @Resource
    private ReportUserRoleMapper reportUserRoleMapper;

    // 你自己实现获取登录账号
    public String getLoginAccount(){
        return null;
    }

    // 你自己实现判断系统管理员
    public boolean isSysAdmin(){
        return false;
    }

    /**
     * 获取当前用户报表角色
     */
    public String getUserReportRole(String reportCode){
        if(isSysAdmin()){
            return ReportRoleConst.ADMIN;
        }
        String account = getLoginAccount();
        ReportUserRole role = reportUserRoleMapper.getByReportAndAccount(reportCode,account);
        return role == null ? ReportRoleConst.VIEWER : role.getRoleType();
    }

    /**
     * 拼接数据权限 where 条件
     * 只过滤 del_flag 和 填写人只能看自己
     */
    public String buildDataWhereSql(String reportCode){
        StringBuilder where = new StringBuilder("WHERE del_flag = " + SysConstant.DEL_FLAG_NORMAL);
        String role = getUserReportRole(reportCode);
        String account = getLoginAccount();

        if(ReportRoleConst.WRITER.equals(role)){
            where.append(" AND create_by = '").append(account).append("' ");
        }
        return where.toString();
    }
}
