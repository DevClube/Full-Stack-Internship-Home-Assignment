package ma.dnaengineering.backend.csvparsertest;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CsvParserTest {

    @Test
    void testParseCsv() throws IOException {
        // Mocking the FileReader for simplicity
        CsvParser csvParser = new CsvParser();
        List<Employee> employees = csvParser.parseCsv("src/test/resources/employees_test.csv");

        assertEquals(3, employees.size());
        // Add more assertions based on the expected data
    }
}
