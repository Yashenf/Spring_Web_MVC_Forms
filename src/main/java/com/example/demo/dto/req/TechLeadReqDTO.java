package com.example.demo.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TechLeadReqDTO {
    private String fullName;
    private String mobile;
    private String email;
}
