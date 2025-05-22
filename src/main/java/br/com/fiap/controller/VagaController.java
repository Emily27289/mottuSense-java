package br.com.fiap.controller;

import br.com.fiap.model.Vaga;
import br.com.fiap.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaRepository repository;

    @GetMapping
    public List<Vaga> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vaga> cadastrar(@RequestBody @Valid Vaga vaga) {
        return ResponseEntity.status(201).body(repository.save(vaga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizar(@PathVariable Long id, @RequestBody @Valid Vaga vagaAtualizada) {
        return repository.findById(id)
                .map(v -> {
                    vagaAtualizada.setId(id);
                    return ResponseEntity.ok(repository.save(vagaAtualizada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return repository.findById(id)
                .map(v -> {
                    repository.delete(v);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
