package com.adu.crud.service.impl;

import com.adu.crud.dao.EmployeeMapper;
import com.adu.crud.entity.EmployeePoJo;
import com.adu.crud.entity.EmployeeVo;
import com.adu.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeePoJo> findALL(EmployeeVo employeeVo) throws Exception {
        return employeeMapper.findALL(employeeVo);
    }
}
