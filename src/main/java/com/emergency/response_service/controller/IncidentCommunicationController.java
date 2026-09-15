package com.emergency.response_service.controller;

import org.springframework.web.bind.annotation.*;

import com.emergency.response_service.client.IncidentClient;
import com.emergency.response_service.client.dto.IncidentResponse;

@RestController
@RequestMapping("/api/incident-info")
public class IncidentCommunicationController {

    private final IncidentClient incidentClient;

    public IncidentCommunicationController(IncidentClient incidentClient) {
        this.incidentClient = incidentClient;
    }

    @GetMapping("/{incidentId}")
    public IncidentResponse getIncident(
            @PathVariable Long incidentId) {

        return incidentClient.getIncidentById(incidentId);
    }
}