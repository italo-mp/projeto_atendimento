package br.indra.atendimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.indra.atendimento.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findByNomeContaining(String nome);
}
