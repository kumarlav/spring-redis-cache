package com.lk.service.impl;

import com.lk.dao.EmployeeRepository;
import com.lk.model.Employee;
import com.lk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public List<Employee> save(List<Employee> entities) {
        return (List<Employee>) repository.saveAll(entities);
    }


    @Override
    @CacheEvict(value = "employees", allEntries = true)
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Cacheable(value = "employees",key = "#empId")
    public Optional<Employee> findById(Integer empId) {
        return repository.findById(empId);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        Page<Employee> entityPage = repository.findAll(pageable);
        List<Employee> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    @CachePut(value = "employees",key = "#empId")
    public Employee update(Employee entity, Integer empId) {
        Optional<Employee> optional = findById(empId);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}