package com.kgisl.controller;

import java.util.List;

import com.kgisl.entity.ProjectBranchMap;
import com.kgisl.service.ProjectBranchMapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * ProjectBranchMapController
 */
@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/projectBranchMaps")
public class ProjectBranchMapController {
    @Autowired
    private ProjectBranchMapService projectBranchMapService;

    @PostMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<Void> createProjectBranchMap(@RequestBody ProjectBranchMap projectBranchMap,
            UriComponentsBuilder ucBuilder) {
        projectBranchMapService.createProjectBranchMap(projectBranchMap);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(projectBranchMap.getProjectbranchid()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<ProjectBranchMap>> all() {
        return new ResponseEntity<>(projectBranchMapService.getProjectBranchMaps(), HttpStatus.OK);
    }
    @GetMapping("/allnativequery")
    public @ResponseBody ResponseEntity<Object[]> allnativequery() {
        return new ResponseEntity<>(projectBranchMapService.getProjectBranchMapsNativeQuery(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectBranchMap> getProjectBranchMapById(@PathVariable("id") long id) {
        ProjectBranchMap projectBranchMap = projectBranchMapService.findByProjectBranchMapId(id);
        if (projectBranchMap == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projectBranchMap, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers="Accept=application/json")
    public ResponseEntity<String> updateProjectBranchMap(@PathVariable("id") long id,@RequestBody ProjectBranchMap currentProjectBranchMap)
    {
        projectBranchMapService.updateProjectBranchMap(id,currentProjectBranchMap);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
    public ResponseEntity<ProjectBranchMap> deleteProjectBranchMap(@PathVariable("id") Long id){
        ProjectBranchMap user = projectBranchMapService.findByProjectBranchMapId(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        projectBranchMapService.deleteProjectBranchMapById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}