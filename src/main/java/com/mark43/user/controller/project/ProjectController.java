package com.mark43.user.controller.project;

import com.mark43.user.dto.project.ProjectDto;
import com.mark43.user.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    @GetMapping
    public ResponseEntity<?> getAllByUser(){
        return this.projectService.getAllByUser();
    }
    @PostMapping
    public ResponseEntity<?> create(ProjectDto dto){
        return this.projectService.create(dto);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, ProjectDto dto){return this.projectService.update(id,dto);}
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){return this.projectService.delete(id);}
}
