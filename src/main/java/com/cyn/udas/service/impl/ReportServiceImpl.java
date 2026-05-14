package com.cyn.udas.service.impl;


import com.cyn.udas.mapper.ReportCommonMapper;
import com.cyn.udas.mapper.ReportDefMapper;
import com.cyn.udas.service.ReportService;
import com.cyn.udas.util.ReportAuthUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportDefMapper reportDefMapper;

    @Resource
    private ReportCommonMapper reportCommonMapper;

    @Resource
    private ReportAuthUtil reportAuthUtil;

    @Override
    public Map<String, Object> reportList(String reportName, Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        List list = reportDefMapper.selectReportList(reportName, offset, pageSize);
        int total = reportDefMapper.selectReportCount(reportName);

        Map<String, Object> map = new HashMap<>();
        map.put("rows", list);
        map.put("total", total);
        return map;
    }

    @Override
    public List<Map<String, Object>> dataList(String reportCode, String tableName, Integer pageNum, Integer pageSize) {
        String where = reportAuthUtil.buildDataWhereSql(reportCode);
        int offset = (pageNum - 1) * pageSize;
        return reportCommonMapper.selectDynamicDataList(tableName, where, offset, pageSize);
    }
}
