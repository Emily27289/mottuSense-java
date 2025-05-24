
package br.com.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FotoRequestDTO {

    @NotNull(message = "ID da moto é obrigatório")
    private Long motoId;

    @NotBlank(message = "Foto é obrigatória")
    private String foto; // Base64 ou URL
}
