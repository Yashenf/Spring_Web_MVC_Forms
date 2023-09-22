package com.example.demo.service.custom.impl;

import com.example.demo.dto.core.ProjectDTO;
import com.example.demo.dto.req.ProjectReqDTO;
import com.example.demo.dto.res.ProjectRespDTO;
import com.example.demo.entity.Project;
import com.example.demo.entity.TechLead;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.repository.TechLeadRepo;
import com.example.demo.service.custom.ProjectService;
import com.example.demo.util.ecxeptions.EntryNotFoundException;
import com.example.demo.util.mappers.ProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepo repo;
    private final TechLeadRepo techLeadRepo;
    private final ProjectsMapper mapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepo repo, TechLeadRepo techLeadRepo) {
        this.repo = repo;
        this.techLeadRepo = techLeadRepo;
        mapper = ProjectsMapper.INSTANCE;
    }

    @Override
    public ProjectRespDTO create(ProjectReqDTO reqDto) {
        //conversion
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setDescription(reqDto.getDescription());
        projectDTO.setStart_day(reqDto.getStartDate());
        projectDTO.setEnd_date(reqDto.getEndDate());
        projectDTO.setTechLead(techLeadRepo.findById(reqDto.getTechLead()).orElseThrow());

        Project entity = mapper.toEntity(projectDTO);
        Optional<TechLead> byId = techLeadRepo.findById(reqDto.getTechLead());
        byId.ifPresent(entity::setTechLead);
        Project saved = repo.save(entity);
        return mapper.toRespDto(saved);
    }

    @Override
    public ProjectRespDTO modify(Integer id, ProjectReqDTO dto) {
        Project project = repo.findById(id).orElseThrow(() -> new EntryNotFoundException("Project No :" + id + " Not Found was occerd!"));
        project.setDescription(dto.getDescription());
        project.setEndDate(dto.getEndDate());
        project.setStartDate(dto.getStartDate());
        Optional<TechLead> byId = techLeadRepo.findById(dto.getTechLead());
        byId.ifPresent(project::setTechLead);
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
