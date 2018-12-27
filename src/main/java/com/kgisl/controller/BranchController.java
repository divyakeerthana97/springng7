package com.kgisl.controller;

import java.util.List;

import com.kgisl.entity.Branch;
import com.kgisl.service.BranchService;

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
 * BranchController
 */
// @CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200/")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<Void> createBranch(@RequestBody Branch branch, UriComponentsBuilder ucBuilder) {
        // System.out.println("Creating branch " + branch.getBranchname());
        branchService.createBranch(branch);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(branch.getBranchid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Branch>> all() {
        // System.out.println("GET ALL CALLED");
        return new ResponseEntity<>(branchService.getBranchs(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Branch> getBranchById(@PathVariable("id") long id) {
        // System.out.println("Fetching Branch with id " + id);
        Branch branch = branchService.findByBranchId(id);
        if (branch == null) {
            return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Branch>(branch, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers="Accept=application/json")
    public ResponseEntity<String> updateBranch(@PathVariable("id") long id,@RequestBody Branch currentBranch)
    {
        // Branch branch = branchService.findByBranchId(currentBranch.findByBranchId(id));
        // if (branch==null) {
        //     return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        // }
        // branch.setBranchname(currentBranch.getBranchname());
        branchService.updateBranch(id,currentBranch);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
    public ResponseEntity<Branch> deleteBranch(@PathVariable("id") Long id){
        Branch user = branchService.findByBranchId(id);
        if (user == null) {
            return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
        }
        branchService.deleteBranchById(id);
        return new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
    }
}