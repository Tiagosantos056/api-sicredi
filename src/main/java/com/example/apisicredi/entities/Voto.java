package com.example.apisicredi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voto {


    @Id
    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private Boolean voto;

    @Getter
    @Setter
    @ManyToOne
    private Pauta pauta;

    @Getter
    @Setter
    private String associadoId;

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public void setPauta(Long pautaId) {
    }
}

