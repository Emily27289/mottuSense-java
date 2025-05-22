package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    Moto findByPlaca(String placa);

    List<Moto> findByStatus(String status);

    List<Moto> findByUrgenciaManutencao(String urgenciaManutencao);
}
