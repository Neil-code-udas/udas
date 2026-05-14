package com.cyn.udas.service.impl;


import com.cyn.udas.service.ReportPermService;
import com.cyn.udas.util.ReportAuthUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportPermServiceImpl implements ReportPermService {

    @Resource
    private ReportAuthUtil reportAuthUtil;

    @Override
    public String getUserRole(String reportCode) {
        return reportAuthUtil.getUserReportRole(reportCode);
    }
}
