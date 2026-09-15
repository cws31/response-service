package com.emergency.response_service.service;

import java.util.List;

import com.emergency.response_service.dto.CreateResponseTeamRequest;
import com.emergency.response_service.dto.ResponseTeamResponse;
import com.emergency.response_service.enums.TeamStatus;

public interface ResponseTeamService {

    ResponseTeamResponse createTeam(CreateResponseTeamRequest request);

    List<ResponseTeamResponse> getAllTeams();

    List<ResponseTeamResponse> getAvailableTeams();

    ResponseTeamResponse getTeamById(Long id);

    ResponseTeamResponse dispatchTeam(Long id);

    ResponseTeamResponse updateTeamStatus(Long id, TeamStatus status);
}