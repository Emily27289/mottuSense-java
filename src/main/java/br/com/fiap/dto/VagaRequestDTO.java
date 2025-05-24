
package br.com.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VagaRequestDTO {

    @NotBlank(message = "Número da vaga é obrigatório")
    private String numero;

    @NotNull(message = "Status de ocupação é obrigatório")
    private Boolean ocupada;

    @NotNull(message = "ID do setor é obrigatório")
    private Long setorId;
}
