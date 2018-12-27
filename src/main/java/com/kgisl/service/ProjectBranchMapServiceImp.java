package com.kgisl.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kgisl.entity.ProjectBranchMap;
import com.kgisl.repository.ProjectBranchMapRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectBranchMapServiceImp implements ProjectBranchMapService {

    @Autowired
    ProjectBranchMapRepository projectBranchMapRepository;

    public ProjectBranchMap createProjectBranchMap(ProjectBranchMap projectBranchMap) {
        return projectBranchMapRepository.save(projectBranchMap);
    }

    public List<ProjectBranchMap> getProjectBranchMaps() {
        return projectBranchMapRepository.findAll();
    }

    public ProjectBranchMap findByProjectBranchMapId(Long id) {
        return projectBranchMapRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    public ProjectBranchMap updateProjectBranchMap(Long id,ProjectBranchMap projectBranchMap) {
        return projectBranchMapRepository.save(projectBranchMap);
    }

    public void deleteProjectBranchMapById(Long id) {
        projectBranchMapRepository.deleteById(id);
    }

    public Object[] getProjectBranchMapsNativeQuery() {
        return  projectBranchMapRepository.findAllProjectBranches();
    }
}
