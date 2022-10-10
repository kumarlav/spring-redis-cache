package com.lk.service;

import com.lk.model.Employee;
import org.springframework.cache.annotation.CachePut;

public interface EmployeeService extends GenericService<Employee, Integer> {
}