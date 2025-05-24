
package br.com.fiap.dto;

import br.com.fiap.model.Foto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FotoResponseDTO {

    private Long id;
    private String foto;
    private LocalDateTime dataRegistro;
    private String placaMoto;

    public static FotoResponseDTO fromEntity(Foto foto) {
        return FotoResponseDTO.builder()
                .id(foto.getId())
                .foto(foto.getFoto())
                .dataRegistro(foto.getDataRegistro())
                .placaMoto(foto.getMoto() != null ? foto.getMoto().getPlaca() : null)
                .build();
    }
}
