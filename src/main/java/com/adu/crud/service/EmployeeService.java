package com.adu.crud.service;

import com.adu.crud.dao.EmployeeMapper;
import com.adu.crud.entity.EmployeePoJo;
import com.adu.crud.entity.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeePoJo> findALL(EmployeeVo employeeVo) throws Exception {
        return employeeMapper.findALL(employeeVo);
    }
}
