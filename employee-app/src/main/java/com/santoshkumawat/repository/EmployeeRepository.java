package com.santoshkumawat.repository;

import com.santoshkumawat.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<com.santoshkumawat.entity.Employee, Long> {
}