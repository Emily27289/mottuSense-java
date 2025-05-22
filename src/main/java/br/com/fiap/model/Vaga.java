package br.com.fiap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Número da vaga é obrigatório")
    private String numero;

    @NotNull(message = "Campo ocupada é obrigatório")
    private Boolean ocupada;

    private LocalDateTime ultimaAtualizacao;

    @ManyToOne
    private Setor setor;

    @OneToOne(mappedBy = "vaga")
    private Moto moto;
}
