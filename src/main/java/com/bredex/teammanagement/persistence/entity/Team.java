package com.bredex.teammanagement.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "established")
    private String established;

    @Column(name = "no_championship_titles")
    private Integer noChampionshipTitles;

    @Column(name = "entry_fee")
    private Boolean entryFee;

    public Team() {
    }

    public Team(Long id, String name, String established, Integer noChampionshipTitles, Boolean entryFee) {
        this.id = id;
        this.name = name;
        this.established = established;
        this.noChampionshipTitles = noChampionshipTitles;
        this.entryFee = entryFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public Integer getNoChampionshipTitles() {
        return noChampionshipTitles;
    }

    public void setNoChampionshipTitles(Integer noChampionshipTitles) {
        this.noChampionshipTitles = noChampionshipTitles;
    }

    public Boolean getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(Boolean entryFee) {
        this.entryFee = entryFee;
    }
}
