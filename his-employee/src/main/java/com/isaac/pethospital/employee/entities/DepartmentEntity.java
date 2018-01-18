package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne()
    @JsonBackReference("CompanyEntity-DepartmentEntity")
    private CompanyEntity company;

    @OneToMany(mappedBy ="department", cascade = CascadeType.ALL)
    @JsonManagedReference("DepartmentEntity-EmployeeEntity")
    private List<EmployeeEntity> employees = new LinkedList<>();
}
