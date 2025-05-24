
package br.com.fiap.controller;

import br.com.fiap.dto.FotoRequestDTO;
import br.com.fiap.dto.FotoResponseDTO;
import br.com.fiap.model.Foto;
import br.com.fiap.model.Moto;
import br.com.fiap.repository.FotoRepository;
import br.com.fiap.repository.MotoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    @Autowired
    private FotoRepository fotoRepository;

    @Autowired
    private MotoRepository motoRepository;

    @GetMapping
    public List<FotoResponseDTO> listarTodas() {
        return fotoRepository.findAll()
                .stream()
                .map(FotoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> buscarPorId(@PathVariable Long id) {
        return fotoRepository.findById(id)
                .map(FotoResponseDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FotoResponseDTO> cadastrar(@RequestBody @Valid FotoRequestDTO dto) {
        Moto moto = motoRepository.findById(dto.getMotoId())
                .orElseThrow(() -> new IllegalArgumentException("Moto não encontrada"));

        Foto foto = Foto.builder()
                .moto(moto)
                .foto(dto.getFoto())
                .dataRegistro(LocalDateTime.now())
                .build();

        return ResponseEntity.status(201).body(FotoResponseDTO.fromEntity(fotoRepository.save(foto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return fotoRepository.findById(id)
                .map(f -> {
                    fotoRepository.delete(f);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
