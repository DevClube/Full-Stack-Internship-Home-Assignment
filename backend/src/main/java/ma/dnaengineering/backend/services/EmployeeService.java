package ma.dnaengineering.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.dnaengineering.backend.models.employes;
import ma.dnaengineering.backend.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<employes> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<employes> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public employes saveEmployee(employes employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
