package com.example.demo.controllers;

import com.example.demo.dto.req.ProjectReqDTO;
import com.example.demo.dto.res.ProjectRespDTO;
import com.example.demo.service.custom.ProjectService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService service;

    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody ProjectReqDTO form){

        System.out.println(form);
        form.setStartDate(form.getStartDate());
        form.setEndDate(form.getEndDate());
        ProjectRespDTO resp = service.create(form);
        return new ResponseEntity<>(new StandardResponse(201, "OK", resp), HttpStatus.CREATED);

    }

    @PutMapping("/{pid}")
    public ResponseEntity<StandardResponse> modify(@PathVariable Integer pid, @ModelAttribute ProjectReqDTO dto){
        ProjectRespDTO modified = service.modify(pid, dto);
        return new ResponseEntity<>(
                new StandardResponse(
                        202,
                        "Modified",
                        modified
                ), HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> remove(@RequestParam Integer id){
        ProjectRespDTO removed = service.remove(id);
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        "Removed",
                        removed
                ), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> show(@PathVariable Integer id){
        ProjectRespDTO projectRespDTO = service.showOne(id);
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        "Found",
                        projectRespDTO
                ), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> showAll(){
        List<ProjectRespDTO> projects = service.showAll();
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        "Found",
                        projects
                ), HttpStatus.OK
        );
    }
}
