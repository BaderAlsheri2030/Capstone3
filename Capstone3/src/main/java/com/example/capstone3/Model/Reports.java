package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String report_type;
    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @NotEmpty
    @Column(columnDefinition = "varchar(100) not null")
     private String Summary;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
     private  String Format;
    @Column(columnDefinition = "varchar(50)")
     private String note;


}
