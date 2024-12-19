package com.soap.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soap.pokemon.model.LogEndpoint;

public interface LogEndpointRepository extends JpaRepository<LogEndpoint, Long> {
}
