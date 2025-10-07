package com.giovana.cadastro_usuario.controller;

import com.giovana.cadastro_usuario.business.ReceitaService;
import com.giovana.cadastro_usuario.infrastructure.entitys.Receita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Receita receita) {
        receitaService.salvarReceita(receita);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Receita> buscar(@RequestParam String titulo) {
        return ResponseEntity.ok(receitaService.buscarPorTitulo(titulo));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestParam String titulo) {
        receitaService.deletarPorTitulo(titulo);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestParam Integer id, @RequestBody Receita receita) {
        receitaService.atualizarReceita(id, receita);
        return ResponseEntity.ok().build();
    }
}
