package com.kgisl.repository;

import java.util.List;
import java.util.Objects;

import com.kgisl.entity.ProjectBranchMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectBranchMapRepository extends JpaRepository<ProjectBranchMap, Long> {

    @Query(
  value = "SELECT projectbranchmap.projectbranchid,projectbranchmap.dburl,projectbranchmap.giturl,projectbranchmap.serverurl, projectname, branchname FROM project JOIN projectbranchmap ON project.projectid=projectbranchmap.projectid JOIN branch ON projectbranchmap.branchid=branch.branchid", 
  nativeQuery = true)
    Object[] findAllProjectBranches();



}