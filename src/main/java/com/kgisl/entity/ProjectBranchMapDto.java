package com.kgisl.entity;



/**
 * ProjectBranchMap
 */

public class ProjectBranchMapDto {


    private Long projectbranchid;
    private Long projectid;
    private Long branchid;
    private String giturl;
    private String serverurl;
    private String dburl;

    /**
     * @return the projectbranchid
     */
    public Long getProjectbranchid() {
        return projectbranchid;
    }
    /**
     * @param projectbranchid the projectbranchid to set
     */
    public void setProjectbranchid(Long projectbranchid) {
        this.projectbranchid = projectbranchid;
    }
    /**
     * @return the projectid
     */
    public Long getProjectid() {
        return projectid;
    }
    /**
     * @param projectid the projectid to set
     */
    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }
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
     * @return the giturl
     */
    public String getGiturl() {
        return giturl;
    }
    /**
     * @param giturl the giturl to set
     */
    public void setGiturl(String giturl) {
        this.giturl = giturl;
    }
    /**
     * @return the serverurl
     */
    public String getServerurl() {
        return serverurl;
    }
    /**
     * @param serverurl the serverurl to set
     */
    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }
    /**
     * @return the dburl
     */
    public String getDburl() {
        return dburl;
    }
    /**
     * @param dburl the dburl to set
     */
    public void setDburl(String dburl) {
        this.dburl = dburl;
    }
}