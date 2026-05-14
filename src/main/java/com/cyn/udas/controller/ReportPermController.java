package com.cyn.udas.controller;

import com.cyn.udas.service.ReportPermService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/report/perm")
public class ReportPermController {

    @Resource
    private ReportPermService reportPermService;

    @GetMapping("/getRole")
    public String getRole(@RequestParam String reportCode) {
        return reportPermService.getUserRole(reportCode);
    }
}
