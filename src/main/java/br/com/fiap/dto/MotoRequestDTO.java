
package br.com.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MotoRequestDTO {

    @NotBlank(message = "Placa é obrigatória")
    private String placa;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    private String numeroIdentificacaoLateral;
    private String motor;
    private String chassi;

    @NotBlank(message = "Status é obrigatório")
    private String status;

    private String urgenciaManutencao;
    private String descricaoProblema;

    private Long vagaId;
}
