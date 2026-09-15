package com.emergency.response_service.dto;

import com.emergency.response_service.enums.TeamStatus;

import jakarta.validation.constraints.NotNull;

public class UpdateTeamStatusRequest {

    @NotNull
    private TeamStatus status;

    public TeamStatus getStatus() {
        return status;
    }

    public void setStatus(TeamStatus status) {
        this.status = status;
    }
}