package com.emergency.response_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.emergency.response_service.dto.CreateResponseTeamRequest;
import com.emergency.response_service.dto.DispatchTeamRequest;
import com.emergency.response_service.dto.ResponseTeamResponse;
import com.emergency.response_service.dto.UpdateTeamStatusRequest;
import com.emergency.response_service.service.ResponseTeamService;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class ResponseTeamController {

    private final ResponseTeamService service;

    public ResponseTeamController(ResponseTeamService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseTeamResponse createTeam(
            @Valid @RequestBody CreateResponseTeamRequest request) {

        return service.createTeam(request);
    }

    @GetMapping
    public List<ResponseTeamResponse> getAllTeams() {

        return service.getAllTeams();
    }

    @GetMapping("/available")
    public List<ResponseTeamResponse> getAvailableTeams() {

        return service.getAvailableTeams();
    }

    @GetMapping("/{id}")
    public ResponseTeamResponse getTeamById(@PathVariable Long id) {

        return service.getTeamById(id);
    }

    @PostMapping("/dispatch")
    public ResponseTeamResponse dispatchTeam(
            @Valid @RequestBody DispatchTeamRequest request) {

        return service.dispatchTeam(request.getTeamId());
    }

    @PatchMapping("/{id}/status")
    public ResponseTeamResponse updateTeamStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTeamStatusRequest request) {

        return service.updateTeamStatus(
                id,
                request.getStatus());
    }
}