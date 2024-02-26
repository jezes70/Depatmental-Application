package com.cyngofokgloba.Springbootdemo.service;

import com.cyngofokgloba.Springbootdemo.entity.Department;
import com.cyngofokgloba.Springbootdemo.error.DepartmentNotfoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long department) throws DepartmentNotfoundException;

    public void deleteDepartmentById(Long departmentId);

     public Department updateDepartment(Long departmentId, Department department);

     public Department fetchDepartmentByName(String departmentName);
}
