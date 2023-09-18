package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String description;
    private Date start_day;
    private Date end_date;
    @ManyToOne
    @JoinColumn(name = "assigned_techLead")
    private TechLead techLead;
}
