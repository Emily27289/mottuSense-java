
package br.com.fiap.controller;

import br.com.fiap.dto.VagaRequestDTO;
import br.com.fiap.dto.VagaResponseDTO;
import br.com.fiap.model.Setor;
import br.com.fiap.model.Vaga;
import br.com.fiap.repository.SetorRepository;
import br.com.fiap.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public List<VagaResponseDTO> listarTodos() {
        return vagaRepository.findAll()
                .stream()
                .map(VagaResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaResponseDTO> buscarPorId(@PathVariable Long id) {
        return vagaRepository.findById(id)
                .map(VagaResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VagaResponseDTO> cadastrar(@RequestBody @Valid VagaRequestDTO dto) {
        Setor setor = setorRepository.findById(dto.getSetorId())
                .orElseThrow(() -> new IllegalArgumentException("Setor não encontrado"));

        Vaga vaga = Vaga.builder()
                .numero(dto.getNumero())
                .ocupada(dto.getOcupada())
                .setor(setor)
                .ultimaAtualizacao(LocalDateTime.now())
                .build();

        return ResponseEntity.status(201).body(VagaResponseDTO.fromEntity(vagaRepository.save(vaga)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VagaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid VagaRequestDTO dto) {
        return vagaRepository.findById(id)
                .map(v -> {
                    Setor setor = setorRepository.findById(dto.getSetorId())
                            .orElseThrow(() -> new IllegalArgumentException("Setor não encontrado"));
                    v.setNumero(dto.getNumero());
                    v.setOcupada(dto.getOcupada());
                    v.setSetor(setor);
                    v.setUltimaAtualizacao(LocalDateTime.now());
                    return ResponseEntity.ok(VagaResponseDTO.fromEntity(vagaRepository.save(v)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable Long id) {
    return vagaRepository.findById(id)
            .map(v -> {
                vagaRepository.delete(v);
                return ResponseEntity.noContent().<Void>build();  // 🔧 Aqui está o fix
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
