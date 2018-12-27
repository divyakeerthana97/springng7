package com.kgisl.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kgisl.entity.Branch;
import com.kgisl.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BranchServiceImp implements BranchService {

    @Autowired
    BranchRepository branchRepository;

    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public List<Branch> getBranchs() {
        return branchRepository.findAll();
    }

    public Branch findByBranchId(Long id) {
        return branchRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    public Branch updateBranch(Long id,Branch branch) {
        Branch t = branchRepository.getOne(id);
        t.setBranchname(branch.getBranchname());
        return branchRepository.save(t);
    }

    public void deleteBranchById(Long id) {
        branchRepository.deleteById(id);
    }
}