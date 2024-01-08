package ma.dnaengineering.backend.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
@Entity
public class employes {
    @Id
    private int id;
    private String employeeName;
    private String jobTitle;
    private double salary;
    public employes() {
    }
    
    
}
