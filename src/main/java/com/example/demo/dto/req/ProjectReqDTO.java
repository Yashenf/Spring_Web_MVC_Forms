package com.example.demo.dto.req;

import com.example.demo.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectReqDTO {
    private String description;
    private Date start_day;
    private Date end_date;
    private TechLead techLead;
}
