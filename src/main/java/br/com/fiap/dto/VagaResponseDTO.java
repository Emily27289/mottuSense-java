
package br.com.fiap.dto;

import br.com.fiap.model.Vaga;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VagaResponseDTO {

    private Long id;
    private String numero;
    private Boolean ocupada;
    private LocalDateTime ultimaAtualizacao;
    private String setorNome;

    public static VagaResponseDTO fromEntity(Vaga vaga) {
        return VagaResponseDTO.builder()
                .id(vaga.getId())
                .numero(vaga.getNumero())
                .ocupada(vaga.getOcupada())
                .ultimaAtualizacao(vaga.getUltimaAtualizacao())
                .setorNome(vaga.getSetor() != null ? vaga.getSetor().getNome() : null)
                .build();
    }
}
