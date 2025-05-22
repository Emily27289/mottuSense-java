package br.com.fiap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "A moto é obrigatória")
    private Moto moto;

    @ManyToOne
    @NotNull(message = "O setor é obrigatório")
    private Setor setor;

    @NotNull(message = "Data e hora de entrada são obrigatórias")
    private LocalDateTime dataHoraEntrada;

    private LocalDateTime dataHoraSaida;
}
