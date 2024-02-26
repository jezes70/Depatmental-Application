package com.cyngofokgloba.Springbootdemo.repository;

import com.cyngofokgloba.Springbootdemo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Customer")
                        .departmentCode("Customer-01")
                        .departmentAddress("39 Bishop Johnson Street")
                        .build();

        entityManager.persist(department);
    }

    private void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1l).get();
        assertEquals(department.getDepartmentName(), "Customer");
    }
}