package com.cyngofokgloba.Springbootdemo.service;

import com.cyngofokgloba.Springbootdemo.entity.Department;
import com.cyngofokgloba.Springbootdemo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {


    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Account")
                        .departmentAddress("32 Good New Estate")
                        .departmentCode("Account-04")
                        .departmentId(1l)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Account"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data Based on Validated Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "Account";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}