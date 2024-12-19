package com.soap.pokemon.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_endpoints")
public class LogEndpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipDeOrigen;
    private LocalDateTime fechaRequest;
    private String metodo;
    private Long tiempoPeticion;
    private String request;
    private String response;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIpDeOrigen() { return ipDeOrigen; }
    public void setIpDeOrigen(String ipDeOrigen) { this.ipDeOrigen = ipDeOrigen; }

    public LocalDateTime getFechaRequest() { return fechaRequest; }
    public void setFechaRequest(LocalDateTime fechaRequest) { this.fechaRequest = fechaRequest; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public Long getTiempoPeticion() { return tiempoPeticion; }
    public void setTiempoPeticion(Long tiempoPeticion) { this.tiempoPeticion = tiempoPeticion; }

    public String getRequest() { return request; }
    public void setRequest(String request) { this.request = request; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
}
