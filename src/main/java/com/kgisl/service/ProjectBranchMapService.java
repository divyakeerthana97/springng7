package com.kgisl.service;

import java.util.List;

import com.kgisl.entity.ProjectBranchMap;



public interface ProjectBranchMapService {

    public ProjectBranchMap createProjectBranchMap(ProjectBranchMap projectBranchMap);
    public List<ProjectBranchMap> getProjectBranchMaps();
    public ProjectBranchMap findByProjectBranchMapId(Long id);
    public ProjectBranchMap updateProjectBranchMap(Long id,ProjectBranchMap projectBranchMap);
    public void deleteProjectBranchMapById(Long id); 

}
