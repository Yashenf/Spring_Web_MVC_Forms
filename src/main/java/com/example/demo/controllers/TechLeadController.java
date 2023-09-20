package com.example.demo.controllers;

import com.example.demo.dto.req.TechLeadReqDTO;
import com.example.demo.dto.res.TechLeadRespDTO;
import com.example.demo.entity.TechLead;
import com.example.demo.service.custom.impl.TechLeadServiceImpl;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/techLeads")
public class TechLeadController {
    private final TechLeadServiceImpl service;

    @Autowired
    public TechLeadController(TechLeadServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@ModelAttribute TechLeadReqDTO form){
        TechLeadRespDTO resp = service.create(form);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"OK",resp), HttpStatus.CREATED);

    }

    @PutMapping("/{tid}")
    public ResponseEntity<StandardResponse> modify(@PathVariable Integer tid, @ModelAttribute TechLeadReqDTO dto){
        TechLeadRespDTO modified = service.modify(tid, dto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        202,
                        "Modified",
                        modified
                ),HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> remove(@RequestParam Integer id){
        TechLeadRespDTO removed = service.remove(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        204,
                        "Removed",
                        removed
                ),HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> show(@PathVariable Integer id){
        TechLeadRespDTO techLeadRespDTO = service.showOne(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "Found",
                        techLeadRespDTO
                ),HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> showAll(){
        List<TechLeadRespDTO> techLeads = service.showAll();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "Found",
                        techLeads
                ),HttpStatus.OK
        );
    }
}
