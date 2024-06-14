package com.example.apisicredi.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String titulo;

    @Getter
    @Setter
    private LocalDateTime inicioSessao;

    @Getter
    @Setter
    private LocalDateTime fimSessao;

    @OneToMany(mappedBy = "pauta")
    @Getter
    @Setter
    private List<Voto> votos;

}