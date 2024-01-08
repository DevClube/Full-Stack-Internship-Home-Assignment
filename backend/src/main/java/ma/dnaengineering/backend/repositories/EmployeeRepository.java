package ma.dnaengineering.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.dnaengineering.backend.models.employes;

public interface EmployeeRepository extends JpaRepository<employes, Long> {
    // You can add custom query methods here if needed
}
