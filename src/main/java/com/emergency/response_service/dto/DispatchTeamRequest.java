package com.emergency.response_service.dto;

import jakarta.validation.constraints.NotNull;

public class DispatchTeamRequest {

    @NotNull
    private Long teamId;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}