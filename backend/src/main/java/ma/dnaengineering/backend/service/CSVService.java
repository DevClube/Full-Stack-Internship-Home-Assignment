package ma.dnaengineering.backend.service;


import ma.dnaengineering.backend.helper.CSVHelper;
import ma.dnaengineering.backend.model.Employee;
import ma.dnaengineering.backend.repository.EmployeeRepository;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;




@Service
public class CSVService {
    @Autowired
    EmployeeRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Employee> employees = CSVHelper.csvToEmployees(file.getInputStream());
            repository.saveAll(employees);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Employee> employees = repository.findAll();

        ByteArrayInputStream in = CSVHelper.employeeToCSV(employees);
        return in;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}