package com.kgisl.service;

import java.util.List;
import java.util.Optional;

import com.kgisl.entity.Project;



public interface ProjectService {

    public Project createProject(Project team);
    public List<Project> getProjects();
    public Project findByProjectId(Long id);
    public Project updateProject(Long id,Project team);
    public void deleteProjectById(Long id); 

}
