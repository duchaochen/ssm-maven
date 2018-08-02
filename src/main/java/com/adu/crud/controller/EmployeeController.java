package com.adu.crud.controller;

import com.adu.crud.entity.EmployeePoJo;
import com.adu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String list(@RequestParam(value = "pageIndex",defaultValue = "1")
                                   Integer pageIndex, Model model) throws Exception {

        PageHelper.startPage(pageIndex, pageSize);
        List<EmployeePoJo> employees = employeeService.findALL(null);
        //用PageInfo对结果进行包装,每次连续显示为5页
        PageInfo<EmployeePoJo> pageInfo = new PageInfo<>(employees,5);

//        System.out.println("当前页码："+pageInfo.getPageNum());
//        System.out.println("总页码："+pageInfo.getPages());
//        System.out.println("总记录数"+pageInfo.getTotal());
//        System.out.println("当前页码显示页码号");
//        int[] number = pageInfo.getNavigatepageNums();
//        for (int num : number) {
//            System.out.print(num+",");
//        }
//        System.out.println("数据源:"+pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);

        return "emplist";
    }
}
