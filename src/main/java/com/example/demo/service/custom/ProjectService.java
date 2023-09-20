package com.example.demo.service.custom;

import com.example.demo.dto.req.ProjectReqDTO;
import com.example.demo.dto.res.ProjectRespDTO;
import com.example.demo.service.SuperService;

import java.util.List;

public interface ProjectService extends SuperService<ProjectReqDTO,ProjectRespDTO,Integer> {
}
