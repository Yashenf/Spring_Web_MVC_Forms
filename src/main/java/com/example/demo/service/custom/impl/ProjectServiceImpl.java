package com.example.demo.service.custom.impl;

import com.example.demo.dto.req.ProjectReqDTO;
import com.example.demo.dto.res.ProjectRespDTO;
import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.service.custom.ProjectService;
import com.example.demo.util.ecxeptions.EntryNotFoundException;
import com.example.demo.util.mappers.ProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepo repo;
    private final ProjectsMapper mapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepo repo) {
        this.repo = repo;
        mapper = ProjectsMapper.INSTANCE;
    }

    @Override
    public ProjectRespDTO create(ProjectReqDTO reqDto) {
        Project saved = repo.save(mapper.toEntity(reqDto));
        return mapper.toRespDto(saved);
    }

    @Override
    public ProjectRespDTO modify(Integer id, ProjectReqDTO dto) {
        Project project = repo.findById(id).orElseThrow(() -> new EntryNotFoundException("Project No :" + id + " Not Found was occerd!"));
        project.setDescription(dto.getDescription());
        project.setEnd_date(dto.getEnd_date());
        project.setStart_day(dto.getStart_day());
        project.setTechLead(dto.getTechLead());
        return  mapper.toRespDto(repo.save(project));
    }

    @Override
    public ProjectRespDTO showOne(Integer id) {
        Project project = repo.findById(id).orElseThrow(() -> new EntryNotFoundException("Project No :" + id + " Not Found was occerd!"));
        return mapper.toRespDto(project);
    }

    @Override
    public ProjectRespDTO remove(Integer id) {
        Project project = repo.findById(id).orElseThrow(() -> new EntryNotFoundException("Project No :" + id + " Not Found was occerd!"));
        repo.delete(project);
        return mapper.toRespDto(project);
    }

    @Override
    public List<ProjectRespDTO> showAll() {
        return mapper.toResponses(repo.findAll());
    }
}
