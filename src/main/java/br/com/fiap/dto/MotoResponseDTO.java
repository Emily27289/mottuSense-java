package br.com.fiap.dto;

import br.com.fiap.model.Moto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Builder
public class MotoResponseDTO {

    private Long id;
    private String placa;
    private String modelo;
    private String numeroIdentificacaoLateral;
    private String motor;
    private String chassi;
    private String status;
    private String urgenciaManutencao;
    private String descricaoProblema;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private String vagaNumero;
    private String setorNome;
    private Integer tempoUsoEmDias;

    public static MotoResponseDTO fromEntity(Moto moto) {
        return MotoResponseDTO.builder()
                .id(moto.getId())
                .placa(moto.getPlaca())
                .modelo(moto.getModelo())
                .numeroIdentificacaoLateral(moto.getNumeroIdentificacaoLateral())
                .motor(moto.getMotor())
                .chassi(moto.getChassi())
                .status(moto.getStatus())
                .urgenciaManutencao(moto.getUrgenciaManutencao())
                .descricaoProblema(moto.getDescricaoProblema())
                .dataEntrada(moto.getDataEntrada())
                .dataSaida(moto.getDataSaida())
                .vagaNumero(moto.getVaga() != null ? moto.getVaga().getNumero() : null)
                .setorNome(moto.getVaga() != null && moto.getVaga().getSetor() != null
                        ? moto.getVaga().getSetor().getNome() : null)
                .tempoUsoEmDias(moto.getDataEntrada() != null
                        ? (int) ChronoUnit.DAYS.between(moto.getDataEntrada(), LocalDateTime.now()) : 0)
                .build();
    }
}
