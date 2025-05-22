package br.com.fiap.controller;

import br.com.fiap.model.Setor;
import br.com.fiap.repository.SetorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository repository;

    @GetMapping
    public List<Setor> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Setor> cadastrar(@RequestBody @Valid Setor setor) {
        return ResponseEntity.status(201).body(repository.save(setor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Setor> atualizar(@PathVariable Long id, @RequestBody @Valid Setor setorAtualizado) {
        return repository.findById(id)
                .map(s -> {
                    setorAtualizado.setId(id);
                    return ResponseEntity.ok(repository.save(setorAtualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return repository.findById(id)
                .map(s -> {
                    repository.delete(s);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
