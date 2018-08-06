package com.adu.crud.dao;

import com.adu.crud.entity.EmployeePoJo;
import com.adu.crud.entity.EmployeeVo;

import java.util.List;

public interface EmployeeMapper {
    void insertALL(EmployeePoJo p) throws Exception;
    List<EmployeePoJo> findALL(EmployeeVo v) throws Exception;
}