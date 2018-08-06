package com.adu.crud.controller;

import com.adu.crud.entity.EmployeePoJo;
import com.adu.crud.service.EmployeeService;
import com.adu.crud.utils.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    /**
     * 每页显示行数
     */
    @Value("${global.pageSize}")
    private int pageSize;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list")
    @ResponseBody
    public Message list(@RequestParam(value = "pageIndex",defaultValue = "1")
                                   Integer pageIndex) throws Exception {
        PageHelper.startPage(pageIndex, pageSize);
        List<EmployeePoJo> employees = employeeService.findALL(null);
        //用PageInfo对结果进行包装,每次连续显示为5页
        PageInfo<EmployeePoJo> pageInfo = new PageInfo<>(employees,5);
        return Message.getSuccess().addAttribute("pageInfo",pageInfo);
    }
}
