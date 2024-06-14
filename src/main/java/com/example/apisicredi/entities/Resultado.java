package com.example.apisicredi.entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Resultado {

    @Id
    @Getter
    @Setter
    private Long idPauta;


    @Getter
    @Setter
    private Map<String, Integer> contagemVotos = new HashMap<>();

}