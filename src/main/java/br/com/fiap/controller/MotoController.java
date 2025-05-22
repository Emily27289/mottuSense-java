package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.model.Moto;
import br.com.fiap.repository.MotoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoRepository repository;

    @GetMapping
    public Page<Moto> listarTodas(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Moto> cadastrar(@RequestBody @Valid Moto moto) {
        return ResponseEntity.status(201).body(repository.save(moto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moto> atualizar(@PathVariable Long id, @RequestBody @Valid Moto novaMoto) {
        return repository.findById(id)
                .map(m -> {
                    novaMoto.setId(id);
                    return ResponseEntity.ok(repository.save(novaMoto));
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
