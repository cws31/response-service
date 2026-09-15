package com.emergency.response_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emergency.response_service.client.dto.IncidentResponse;

@FeignClient(name = "incident-service", url = "${incident-service.url}")
public interface IncidentClient {

    @GetMapping("/api/incidents/{id}")
    IncidentResponse getIncidentById(@PathVariable Long id);
}