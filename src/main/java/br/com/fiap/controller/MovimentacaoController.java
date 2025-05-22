package br.com.fiap.controller;

import br.com.fiap.model.Movimentacao;
import br.com.fiap.repository.MovimentacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @GetMapping
    public List<Movimentacao> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movimentacao> cadastrar(@RequestBody @Valid Movimentacao movimentacao) {
        return ResponseEntity.status(201).body(repository.save(movimentacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> atualizar(@PathVariable Long id, @RequestBody @Valid Movimentacao movAtualizada) {
        return repository.findById(id)
                .map(m -> {
                    movAtualizada.setId(id);
                    return ResponseEntity.ok(repository.save(movAtualizada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return repository.findById(id)
                .map(m -> {
                    repository.delete(m);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
