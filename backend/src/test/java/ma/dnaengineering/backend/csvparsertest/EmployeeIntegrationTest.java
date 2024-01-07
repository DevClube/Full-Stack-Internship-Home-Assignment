package ma.dnaengineering.backend.csvparsertest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetEmployees() {
        ResponseEntity<List<Employee>> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/employees",
                List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions based on the expected data
    }

    @Test
    void testGetJobTitleSummary() {
        ResponseEntity<Map<String, Double>> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/job-summary",
                Map.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions based on the expected data
    }
}
