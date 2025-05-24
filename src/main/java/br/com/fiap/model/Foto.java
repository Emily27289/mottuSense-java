package br.com.fiap.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "moto_id", nullable = false)
    private Moto moto;

    @Lob
    private String foto; // Pode ser base64 ou URL

    private LocalDateTime dataRegistro;
} 
