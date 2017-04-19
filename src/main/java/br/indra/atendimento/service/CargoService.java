package br.indra.atendimento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.indra.atendimento.model.Cargo;
import br.indra.atendimento.repository.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public List<Cargo> buscarCargos() {
		return cargoRepository.findAll();
	}

}
