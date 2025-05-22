package br.com.fiap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do setor é obrigatório")
    private String nome;

    @NotBlank(message = "Tipo do setor é obrigatório")
    private String tipo;

    private String sensorId;
}
