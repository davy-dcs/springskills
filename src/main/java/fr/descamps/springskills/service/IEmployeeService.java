package fr.descamps.springskills.service;

import fr.descamps.springskills.domain.Employee;

import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> getEmployee(final Long id);
    Iterable<Employee> getEmployees();
    void deleteEmployee(final Long id);
    Employee saveEmployee(Employee employee);
    Integer getTotal();
}
