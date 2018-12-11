package com.kgisl.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.kgisl.entity.ProjectBranchMap;
import com.kgisl.service.ProjectBranchMapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

/**
 * ProjectBranchMapController
 */
// @CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200/")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/projectBranchMaps")
public class ProjectBranchMapController {
    @Autowired
    private ProjectBranchMapService projectBranchMapService;

    @PostMapping(value="/",headers="Accept=application/json")
    public ResponseEntity<Void> createProjectBranchMap(@RequestBody ProjectBranchMap projectBranchMap, UriComponentsBuilder ucBuilder){
        System.out.println("Creating projectBranchMap "+projectBranchMap.getProjectbranchid());
        projectBranchMapService.createProjectBranchMap(projectBranchMap);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(projectBranchMap.getProjectbranchid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<ProjectBranchMap>> all() {
        System.out.println("GET ALL CALLED");
        return new ResponseEntity<>(projectBranchMapService.getProjectBranchMaps(), HttpStatus.OK);
    }
    @GetMapping("/allnativequery")
    public @ResponseBody ResponseEntity<Object[]> allnativequery() {
        System.out.println("GET ALL CALLED");
        return new ResponseEntity<>(projectBranchMapService.getProjectBranchMapsNativeQuery(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectBranchMap> getProjectBranchMapById(@PathVariable("id") long id) {
        System.out.println("Fetching ProjectBranchMap with id " + id);
        ProjectBranchMap projectBranchMap = projectBranchMapService.findByProjectBranchMapId(id);
        if (projectBranchMap == null) {
            return new ResponseEntity<ProjectBranchMap>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProjectBranchMap>(projectBranchMap, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers="Accept=application/json")
    public ResponseEntity<String> updateProjectBranchMap(@PathVariable("id") long id,@RequestBody ProjectBranchMap currentProjectBranchMap)
    {
        // ProjectBranchMap projectBranchMap = projectBranchMapService.findByProjectBranchMapId(currentProjectBranchMap.findByProjectBranchMapId(id));
        // if (projectBranchMap==null) {
        //     return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        // }
        // projectBranchMap.setProjectBranchMapname(currentProjectBranchMap.getProjectBranchMapname());
        projectBranchMapService.updateProjectBranchMap(id,currentProjectBranchMap);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
    public ResponseEntity<ProjectBranchMap> deleteProjectBranchMap(@PathVariable("id") Long id){
        ProjectBranchMap user = projectBranchMapService.findByProjectBranchMapId(id);
        if (user == null) {
            return new ResponseEntity<ProjectBranchMap>(HttpStatus.NOT_FOUND);
        }
        projectBranchMapService.deleteProjectBranchMapById(id);
        return new ResponseEntity<ProjectBranchMap>(HttpStatus.NO_CONTENT);
    }
}