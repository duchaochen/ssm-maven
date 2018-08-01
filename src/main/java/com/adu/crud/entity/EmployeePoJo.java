package com.adu.crud.entity;

public class EmployeePoJo extends Employee{

    public EmployeePoJo() {
    }

    public EmployeePoJo(Integer empId, String empName, String gender, Integer deptId) {
        super(empId, empName, gender, deptId);
    }
}
