package com.cyn.udas.entity;

import lombok.Data;
import java.util.Date;

@Data
public class ReportDef {
    private Long id;
    private String reportCode;
    private String reportName;
    private String tableName;

    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String orgCode;
    private String orgName;
    private Integer delFlag;
}
