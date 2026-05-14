package com.cyn.udas.service;

import java.util.List;
import java.util.Map;

public interface ReportService {

    Map<String, Object> reportList(String reportName, Integer pageNum, Integer pageSize);

    List<Map<String, Object>> dataList(String reportCode, String tableName, Integer pageNum, Integer pageSize);
}
