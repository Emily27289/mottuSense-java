
package br.com.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SetorRequestDTO {

    @NotBlank(message = "Nome do setor é obrigatório")
    private String nome;

    @NotBlank(message = "Tipo do setor é obrigatório")
    private String tipo;

    private String sensorId;
}
