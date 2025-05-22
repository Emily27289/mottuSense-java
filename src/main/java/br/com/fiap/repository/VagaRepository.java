package br.com.fiap.repository;

import br.com.fiap.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
