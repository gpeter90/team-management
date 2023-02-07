package com.bredex.teammanagement.domain.dto;

public class TeamRestDto {

    private Long id;
    private String name;
    private String established;
    private Integer noChampionshipTitles;
    private Boolean entryFee;

    public TeamRestDto() {
    }

    public TeamRestDto(Long id, String name, String established, Integer noChampionshipTitles, Boolean entryFee) {
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
