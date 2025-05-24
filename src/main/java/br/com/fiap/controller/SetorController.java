
package br.com.fiap.controller;

import br.com.fiap.dto.SetorRequestDTO;
import br.com.fiap.dto.SetorResponseDTO;
import br.com.fiap.model.Setor;
import br.com.fiap.repository.SetorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository repository;

    @GetMapping
    public List<SetorResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(SetorResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetorResponseDTO> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(SetorResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SetorResponseDTO> cadastrar(@RequestBody @Valid SetorRequestDTO dto) {
        Setor setor = new Setor();
        setor.setNome(dto.getNome());
        setor.setTipo(dto.getTipo());
        setor.setSensorId(dto.getSensorId());
        Setor salvo = repository.save(setor);
        return ResponseEntity.status(201).body(SetorResponseDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SetorResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid SetorRequestDTO dto) {
        return repository.findById(id)
                .map(s -> {
                    s.setNome(dto.getNome());
                    s.setTipo(dto.getTipo());
                    s.setSensorId(dto.getSensorId());
                    return ResponseEntity.ok(SetorResponseDTO.fromEntity(repository.save(s)));
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
