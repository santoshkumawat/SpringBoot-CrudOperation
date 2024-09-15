package com.santoshkumawat.EmployeeApp.service;

import com.santoshkumawat.EmployeeApp.entity.Address;
import com.santoshkumawat.EmployeeApp.entity.Employee;
import com.santoshkumawat.EmployeeApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee){
        ArrayList<Address> addressArrayList = new ArrayList<>();
        for (Address address: employee.getAddresses()){
            addressArrayList.add(new Address(address.getLine1(),
                    address.getLine2(),
                    address.getPinCode(),
                    address.getCity(),
                    address.getState(),
                    address.getCountry(),
                    employee
            ));
        }
        employee.setAddresses(addressArrayList);
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}