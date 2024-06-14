package com.example.apisicredi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Voto {


    @Id
    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String voto;

    public void setPauta(Pauta pauta) {
    }

    public void setAssociadoId(String associadoId) {
    }
}

