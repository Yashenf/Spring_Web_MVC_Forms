package com.example.demo.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TechLeadRespDTO {
    private Integer tId;
    private String fullName;
    private String mobile;
    private String email;
}
