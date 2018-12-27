package com.kgisl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Team
 */
public class TeamDto {
    private Long teamid;
    private String teamname;

    /**
     * @return the teamid
     */
    public Long getTeamid() {
        return teamid;
    }

    /**
     * @param teamid the teamid to set
     */
    public void setTeamid(Long teamid) {
        this.teamid = teamid;
    }

    /**
     * @return the teamname
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * @param teamname the teamname to set
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
}