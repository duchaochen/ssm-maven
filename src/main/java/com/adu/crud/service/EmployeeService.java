package com.adu.crud.service;


import com.adu.crud.entity.EmployeePoJo;
import com.adu.crud.entity.EmployeeVo;

import java.util.List;

public interface EmployeeService {

    List<EmployeePoJo> findALL(EmployeeVo employeeVo) throws Exception;
}
