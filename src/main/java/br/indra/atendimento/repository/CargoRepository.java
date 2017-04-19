package br.indra.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.indra.atendimento.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
