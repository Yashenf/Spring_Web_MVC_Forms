package com.example.demo.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TechLeadRespDTO {
    private Integer id;
    private String fullName;
    private String mobile;
    private String email;
}
