package com.example.apisicredi.controllers;

import com.example.apisicredi.entities.Pauta;
import com.example.apisicredi.services.PautaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public Pauta criarPauta(@RequestParam String titulo) {
        return pautaService.criarPauta(titulo);
    }

    @PostMapping("/{id}/abrir-sessao")
    public Pauta abrirSessao(@PathVariable Long id, @RequestParam(required = false) Long duracao) {
        return pautaService.abrirSessao(id, duracao);
    }
}