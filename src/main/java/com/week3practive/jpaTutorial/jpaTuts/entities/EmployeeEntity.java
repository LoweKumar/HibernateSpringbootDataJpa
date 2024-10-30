package com.week3practive.jpaTutorial.jpaTuts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.Auto)
    private Long id;
}
