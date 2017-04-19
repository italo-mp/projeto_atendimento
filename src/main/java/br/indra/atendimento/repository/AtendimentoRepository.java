package br.indra.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.indra.atendimento.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

	
}
