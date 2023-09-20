package com.example.demo.dto.res;

import com.example.demo.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectRespDTO {
    private Integer projectId;
    private String description;
    private Date start_day;
    private Date end_date;
    private TechLead techLead;
}
