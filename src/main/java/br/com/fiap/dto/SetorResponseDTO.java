
package br.com.fiap.dto;

import br.com.fiap.model.Setor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetorResponseDTO {

    private Long id;
    private String nome;
    private String tipo;
    private String sensorId;

    public static SetorResponseDTO fromEntity(Setor setor) {
        return SetorResponseDTO.builder()
                .id(setor.getId())
                .nome(setor.getNome())
                .tipo(setor.getTipo())
                .sensorId(setor.getSensorId())
                .build();
    }
}
