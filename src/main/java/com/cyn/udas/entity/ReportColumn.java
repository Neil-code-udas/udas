package com.cyn.udas.entity;

import lombok.Data;
import java.util.Date;

@Data
public class ReportColumn {
    private Long id;
    private String reportCode;
    private String columnName;
    private String columnLabel;
    private String columnType;
    private Integer sort;

    private Integer isList;
    private Integer isQuery;
    private Integer isSortable;
    private Integer width;
    private String align;

    private Integer isImport;
    private Integer isExport;
    private Integer isRequired;

    private Integer isDesensitize;
    private String desensitizeType;

    private Integer isSelect;
    private String selectOptions;

    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private Integer delFlag;
}
