package br.com.fiap.repository;

import br.com.fiap.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
