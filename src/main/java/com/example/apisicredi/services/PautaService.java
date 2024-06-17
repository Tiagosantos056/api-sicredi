package com.example.apisicredi.services;

import com.example.apisicredi.entities.Pauta;
import com.example.apisicredi.exceptions.ResourceNotFoundException;
import com.example.apisicredi.repositories.PautaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta criarPauta(String titulo) {
        Pauta pauta = new Pauta();
        pauta.setTitulo(titulo);
        return pautaRepository.save(pauta);
    }

    public Pauta abrirSessao(Long pautaId, Long duracao) {
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada"));
        pauta.setInicioSessao(LocalDateTime.now());
        pauta.setFimSessao(LocalDateTime.now().plusMinutes(duracao != null ? duracao : 1));
        return pautaRepository.save(pauta);
    }

    private void fecharSessao(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada"));
        pauta.setFimSessao(LocalDateTime.now());
        pautaRepository.save(pauta);
    }
}