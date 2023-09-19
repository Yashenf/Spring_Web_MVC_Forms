package com.example.demo.service;

import com.example.demo.dto.req.TechLeadReqDTO;
import com.example.demo.dto.res.TechLeadRespDTO;
import com.example.demo.entity.TechLead;

import java.util.List;

public interface TechLeadService {
    TechLeadRespDTO create(TechLeadReqDTO reqDto);
    TechLeadRespDTO modify(Integer id, TechLeadReqDTO dto);
    TechLeadRespDTO showOne(Integer id);
    TechLeadRespDTO remove(Integer id);
    List<TechLead> showAll();
}
