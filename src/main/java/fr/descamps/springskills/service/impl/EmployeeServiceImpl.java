package fr.descamps.springskills.service.impl;

import fr.descamps.springskills.component.Calcul;
import fr.descamps.springskills.domain.Employee;
import fr.descamps.springskills.repositories.IEmployeeRepository;
import fr.descamps.springskills.service.IEmployeeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository;
    private final ObjectFactory<Calcul> calculFactory;

    @Override
    public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Integer getTotal() {
        Calcul calcul = calculFactory.getObject();
        calcul.setQuantity(4);
        calcul.setPrice(5);
        return calcul.calculSomme();
    }
}
