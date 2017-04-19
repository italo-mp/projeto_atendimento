package br.indra.atendimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.indra.atendimento.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByNomeContaining(String nome);
}
