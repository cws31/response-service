package com.emergency.response_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emergency.response_service.dto.CreateResponseTeamRequest;
import com.emergency.response_service.dto.ResponseTeamResponse;
import com.emergency.response_service.entity.ResponseTeam;
import com.emergency.response_service.enums.TeamStatus;
import com.emergency.response_service.exception.BadRequestException;
import com.emergency.response_service.exception.ResourceNotFoundException;
import com.emergency.response_service.repository.ResponseTeamRepository;

import java.util.List;

@Service
@Transactional
public class ResponseTeamServiceImpl implements ResponseTeamService {

    private final ResponseTeamRepository repository;

    public ResponseTeamServiceImpl(ResponseTeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseTeamResponse createTeam(CreateResponseTeamRequest request) {

        ResponseTeam team = new ResponseTeam();

        team.setName(request.getName());
        team.setType(request.getType());
        team.setStatus(TeamStatus.AVAILABLE);
        team.setLatitude(request.getLatitude());
        team.setLongitude(request.getLongitude());

        return mapToResponse(repository.save(team));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseTeamResponse> getAllTeams() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseTeamResponse> getAvailableTeams() {

        return repository.findByStatus(TeamStatus.AVAILABLE)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseTeamResponse getTeamById(Long id) {

        return mapToResponse(findTeam(id));
    }

    @Override
    public ResponseTeamResponse dispatchTeam(Long id) {

        ResponseTeam team = findTeam(id);

        if (team.getStatus() != TeamStatus.AVAILABLE) {
            throw new BadRequestException(
                    "Team is not available for dispatch");
        }

        team.setStatus(TeamStatus.BUSY);

        return mapToResponse(repository.save(team));
    }

    @Override
    public ResponseTeamResponse updateTeamStatus(
            Long id,
            TeamStatus status) {

        ResponseTeam team = findTeam(id);

        team.setStatus(status);

        return mapToResponse(repository.save(team));
    }

    private ResponseTeam findTeam(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Response team not found with id: " + id));
    }

    private ResponseTeamResponse mapToResponse(ResponseTeam team) {

        ResponseTeamResponse response = new ResponseTeamResponse();

        response.setId(team.getId());
        response.setName(team.getName());
        response.setType(team.getType());
        response.setStatus(team.getStatus());
        response.setLatitude(team.getLatitude());
        response.setLongitude(team.getLongitude());
        response.setCreatedAt(team.getCreatedAt());
        response.setUpdatedAt(team.getUpdatedAt());

        return response;
    }
}