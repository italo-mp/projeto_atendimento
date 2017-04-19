package br.indra.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.indra.atendimento.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
