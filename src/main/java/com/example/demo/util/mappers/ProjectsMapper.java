package com.example.demo.util.mappers;

import com.example.demo.dto.req.ProjectReqDTO;
import com.example.demo.dto.res.ProjectRespDTO;
import com.example.demo.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectsMapper {
    ProjectsMapper INSTANCE =  Mappers.getMapper(ProjectsMapper.class);

    Project toEntity(ProjectReqDTO dto);
    ProjectRespDTO toRespDto(Project p);

    List<ProjectRespDTO> toResponses(List<Project> projects);
}
