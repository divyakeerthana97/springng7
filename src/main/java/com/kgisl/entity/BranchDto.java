package com.kgisl.entity;



/**
 * Branch
 */
public class BranchDto {
    
    private Long branchid;

    private String branchname;
    
  

    /**
     * @return the branchid
     */
    public Long getBranchid() {
        return branchid;
    }

    /**
     * @param branchid the branchid to set
     */
    public void setBranchid(Long branchid) {
        this.branchid = branchid;
    }

    /**
     * @return the branchname
     */
    public String getBranchname() {
        return branchname;
    }

    /**
     * @param branchname the branchname to set
     */
    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }
}