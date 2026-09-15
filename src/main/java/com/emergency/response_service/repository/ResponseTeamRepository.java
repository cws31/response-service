package com.emergency.response_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emergency.response_service.entity.ResponseTeam;
import com.emergency.response_service.enums.TeamStatus;

import java.util.List;

public interface ResponseTeamRepository extends JpaRepository<ResponseTeam, Long> {

    List<ResponseTeam> findByStatus(TeamStatus status);
}