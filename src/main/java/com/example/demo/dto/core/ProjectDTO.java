package com.example.demo.dto.core;

import com.example.demo.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectDTO {
    private Integer projectId;
    private String description;
    private LocalDate start_day;
    private LocalDate end_date;
    private TechLead techLead;
}
