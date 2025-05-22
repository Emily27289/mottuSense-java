package br.com.fiap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Placa é obrigatória")
    @Column(unique = true)
    private String placa;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    private String numeroIdentificacaoLateral;
    private String motor;

    @NotBlank(message = "Status é obrigatório")
    private String status;

    private String urgenciaManutencao;

    private String descricaoProblema;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    @OneToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;
}
