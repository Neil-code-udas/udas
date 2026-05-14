package com.cyn.udas.controller;

import com.cyn.udas.entity.ReportDef;
import com.cyn.udas.mapper.ReportDefMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportIndexController {

    @Resource
    private ReportDefMapper reportDefMapper;

    @GetMapping("/list")
    public Map<String,Object> list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String reportName){

        int offset = (pageNum - 1) * pageSize;
        List<ReportDef> list = reportDefMapper.selectReportList(reportName, offset, pageSize);
        int total = reportDefMapper.selectReportCount(reportName);

        Map<String,Object> result = new HashMap<>();
        result.put("total",total);
        result.put("rows",list);
        return result;
    }
}
