package com.example.apisicredi.controllers;

import com.example.apisicredi.entities.Voto;
import com.example.apisicredi.services.VotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/votos")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public Voto votar(@RequestParam Long pautaId, @RequestParam String associadoId, @RequestParam Boolean voto) {
        return votoService.votar(pautaId, associadoId, voto);
    }

    @GetMapping("/{id}/contabilizar")
    public List<Voto> contabilizarVotos(@PathVariable Long id) {
        return votoService.contabilizarVotos(id);
    }

    @GetMapping("/{id}/resultado")
    public Map<String, Long> resultadoVotacao(@PathVariable Long id) {
        return votoService.resultadoVotacao(id);
    }
}