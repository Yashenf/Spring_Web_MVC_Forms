package com.example.demo.controllers;

import com.example.demo.dto.req.TechLeadReqDTO;
import com.example.demo.dto.res.TechLeadRespDTO;
import com.example.demo.service.TechLeadService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/techLeads")
public class TechLeadController {
    private TechLeadService service;

    @Autowired
    public TechLeadController(TechLeadService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@ModelAttribute TechLeadReqDTO form){
        TechLeadRespDTO resp = service.saveTechLead(form);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"OK",resp), HttpStatus.CREATED);

    }
}
