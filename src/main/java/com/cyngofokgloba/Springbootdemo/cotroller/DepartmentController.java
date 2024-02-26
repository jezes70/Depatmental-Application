package com.cyngofokgloba.Springbootdemo.cotroller;

import com.cyngofokgloba.Springbootdemo.entity.Department;
import com.cyngofokgloba.Springbootdemo.error.DepartmentNotfoundException;
import com.cyngofokgloba.Springbootdemo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

//    @PostMapping("/departments")
//    public Department saveDepartment(@Valid @RequestBody Department department) {
//        LOGGER.info("Inside saveDepartment of DepartmentController");
//        return departmentService.saveDepartment(department);
//
//    }

    @PostMapping("/departments")
    public ResponseEntity<?> saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        Department savedDepartment = departmentService.saveDepartment(department);
        if (savedDepartment == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(savedDepartment);
        }
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotfoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        departmentService.updateDepartment(departmentId,department);
        return departmentService.updateDepartment(departmentId, department);

    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name")String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
