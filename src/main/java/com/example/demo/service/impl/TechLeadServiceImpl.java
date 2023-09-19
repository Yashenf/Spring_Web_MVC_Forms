package com.example.demo.service.impl;

import com.example.demo.dto.req.TechLeadReqDTO;
import com.example.demo.dto.res.TechLeadRespDTO;
import com.example.demo.entity.TechLead;
import com.example.demo.repository.TechLeadRepo;
import com.example.demo.service.TechLeadService;
import com.example.demo.util.ecxeptions.EntryNotFoundException;
import com.example.demo.util.mappers.TechLeadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechLeadServiceImpl implements TechLeadService {
    private TechLeadRepo repo;
    private final TechLeadMapper mapper;

    @Autowired
    public TechLeadServiceImpl(TechLeadRepo repo) {
        this.repo = repo;
        this.mapper=TechLeadMapper.INSTANCE;
    }

    public TechLeadRespDTO create(TechLeadReqDTO reqDto){
        TechLead lead = mapper.toEntity(reqDto);
        TechLead tl= repo.save(lead);
        return mapper.toTechLeadRespDTO(tl);
    }

    @Override
    public TechLeadRespDTO modify(Integer id, TechLeadReqDTO dto) {
        TechLead byId = repo.findById(id).orElseThrow(()-> new EntryNotFoundException("TechLead Id :- "+id+" Not Found "));
        byId.setEmail(dto.getEmail());
        byId.setMobile(dto.getMobile());
        byId.setFullName(dto.getFullName());
        repo.save(byId);
        return mapper.toTechLeadRespDTO(byId);
    }

    @Override
    public TechLeadRespDTO showOne(Integer id) {
        TechLead byId = repo.findById(id).orElseThrow(()-> new EntryNotFoundException("TechLead Id :- "+id+" Not Found "));
        return mapper.toTechLeadRespDTO(byId);
    }

    @Override
    public TechLeadRespDTO remove(Integer id) {
        TechLead byId = repo.findById(id).orElseThrow(()-> new EntryNotFoundException("TechLead Id :- "+id+" Not Found "));
        repo.delete(byId);
        return mapper.toTechLeadRespDTO(byId);
    }

    @Override
    public List<TechLead> showAll() {
        return repo.findAll();
    }
}
