package com.giovana.cadastro_usuario.business;

import com.giovana.cadastro_usuario.infrastructure.entitys.Receita;
import com.giovana.cadastro_usuario.infrastructure.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    private final ReceitaRepository repository;

    public ReceitaService(ReceitaRepository repository) {
        this.repository = repository;
    }

    public void salvarReceita(Receita receita) {
        repository.saveAndFlush(receita);
    }

    public Receita buscarPorTitulo(String titulo) {
        return repository.findByTitulo(titulo).orElseThrow(
                () -> new RuntimeException("Receita não encontrada")
        );
    }

    public void deletarPorTitulo(String titulo) {
        repository.deleteByTitulo(titulo);
    }

    public void atualizarReceita(Integer id, Receita novaReceita) {
        Receita receitaExistente = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Receita não encontrada")
        );

        Receita receitaAtualizada = Receita.builder()
                .id(receitaExistente.getId())
                .titulo(novaReceita.getTitulo() != null ? novaReceita.getTitulo() : receitaExistente.getTitulo())
                .ingredientes(novaReceita.getIngredientes() != null ? novaReceita.getIngredientes() : receitaExistente.getIngredientes())
                .modoPreparo(novaReceita.getModoPreparo() != null ? novaReceita.getModoPreparo() : receitaExistente.getModoPreparo())
                .build();

        repository.saveAndFlush(receitaAtualizada);
    }
}
