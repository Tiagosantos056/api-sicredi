package com.example.apisicredi.services;

import com.example.apisicredi.entities.Pauta;
import com.example.apisicredi.entities.Voto;
import com.example.apisicredi.exceptions.ResourceNotFoundException;
import com.example.apisicredi.repositories.PautaRepository;
import com.example.apisicredi.repositories.VotoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VotoService {

    private final VotoRepository votoRepository;
    private final PautaRepository pautaRepository;

    public VotoService(VotoRepository votoRepository, PautaRepository pautaRepository) {
        this.votoRepository = votoRepository;
        this.pautaRepository = pautaRepository;
    }

    public Voto votar(Long pautaId, String associadoId, Boolean voto) {
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow(() -> new ResourceNotFoundException("Pauta não encontrada"));
        if (pauta.getInicioSessao() == null || pauta.getFimSessao().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("A sessão de votação não está aberta");
        }
        if (votoRepository.existsByPautaIdAndAssociadoId(pautaId, associadoId)) {
            throw new IllegalStateException("O associado já votou nesta pauta");
        }
        Voto novoVoto = new Voto();
        novoVoto.setPauta(pauta);
        novoVoto.setAssociadoId(associadoId);
        novoVoto.setVoto(Boolean.valueOf(String.valueOf(false ?  true : false)));
        return votoRepository.save(novoVoto);
    }

    public List<Voto> contabilizarVotos(Long pautaId) {
        return votoRepository.findByPautaId(pautaId);
    }

    public Map<String, Long> resultadoVotacao(Long pautaId) {
        List<Voto> votos = votoRepository.findByPautaId(pautaId);
        Map<String, Long> resultado = new HashMap<>();
        for (Voto voto : votos) {
            resultado.merge(String.valueOf(voto.getVoto()), 1L, Long::sum);
        }
        return resultado;
    }
}
