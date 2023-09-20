package com.example.demo.service.custom;

import com.example.demo.dto.req.TechLeadReqDTO;
import com.example.demo.dto.res.TechLeadRespDTO;
import com.example.demo.entity.TechLead;
import com.example.demo.service.SuperService;

import java.util.List;

public interface TechLeadService extends SuperService<TechLeadReqDTO,TechLeadRespDTO,Integer> {}
