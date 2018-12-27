package com.kgisl.service;

import java.util.List;

import com.kgisl.entity.Branch;



public interface BranchService {

    public Branch createBranch(Branch branch);
    public List<Branch> getBranchs();
    public Branch findByBranchId(Long id);
    public Branch updateBranch(Long id,Branch branch);
    public void deleteBranchById(Long id); 

}
