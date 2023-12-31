package com.example.demo.dto.res;

import com.example.demo.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectRespDTO {
    private Integer projectId;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private TechLead techLead;
}
