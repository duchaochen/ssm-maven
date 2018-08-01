package com.adu.crud.controller;

import com.adu.crud.entity.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Value("${global.pageSize}")
    private int pageSize;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex, Model model) {

        PageHelper.startPage(pageIndex, pageSize);
        List<Employee> employees = null;
        //用PageInfo对结果进行包装,每次连续显示为5页
        PageInfo<Employee> page = new PageInfo<>(employees,5);
        model.addAttribute("pageInfo",page);
        return "emplist";
    }
}
