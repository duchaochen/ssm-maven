package com.adu.crud.entity;

public class EmployeePoJo extends Employee {

    public EmployeePoJo() {
    }

    public EmployeePoJo(Integer empId, String empName, String gender, String email, Integer deptId) {
        super(empId, empName, gender, email, deptId);
    }
}
