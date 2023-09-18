package com.example.demo.service;

import com.example.demo.dto.req.TechLeadReqDTO;
import com.example.demo.dto.res.TechLeadRespDTO;
import com.example.demo.entity.TechLead;
import com.example.demo.repository.TechLeadRepo;
import com.example.demo.util.mappers.TechLeadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechLeadService {
    private TechLeadRepo repo;
    private final TechLeadMapper mapper;

    @Autowired
    public TechLeadService(TechLeadRepo repo) {
        this.repo = repo;
        this.mapper=TechLeadMapper.INSTANCE;
    }

    public TechLeadRespDTO saveTechLead(TechLeadReqDTO reqDto){
        TechLead lead = mapper.toEntity(reqDto);
        TechLead tl= repo.save(lead);
        return mapper.toTechLeadRespDTO(tl);
    }
}
