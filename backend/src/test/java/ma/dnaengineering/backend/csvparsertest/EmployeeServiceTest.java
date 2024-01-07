package ma.dnaengineering.backend.csvparsertest;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Test
    void testGetAllEmployees() throws IOException {
        // Mocking the CsvParser
        CsvParser csvParser = mock(CsvParser.class);
        when(csvParser.parseCsv(anyString())).thenReturn(getMockEmployees());

        EmployeeService employeeService = new EmployeeService(csvParser);
        List<Employee> employees = employeeService.getAllEmployees("path/to/employees.csv");

        assertEquals(3, employees.size());
        // Add more assertions based on the expected data
    }

    @Test
    void testCalculateJobTitleSummary() throws IOException {
        // Mocking the CsvParser
        CsvParser csvParser = mock(CsvParser.class);
        when(csvParser.parseCsv(anyString())).thenReturn(getMockEmployees());

        EmployeeService employeeService = new EmployeeService(csvParser);
        // Add more tests for calculating job title summary based on the expected data
    }

    // Helper method to provide mock data
    private List<Employee> getMockEmployees() {
        // Create and return a list of mock employees
    }
}
