package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    private Integer statusCode;
    private String description;
    private Object data;
}
