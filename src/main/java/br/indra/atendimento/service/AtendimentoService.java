package br.indra.atendimento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.indra.atendimento.model.Atendimento;
import br.indra.atendimento.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public Boolean salvarAtendimento(Atendimento atendimento) {
		
		try {
			atendimentoRepository.save(atendimento);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean excluirAtendimento(Long id) {
		
		try {
			atendimentoRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Atendimento> buscarAtendimentoPorNome(String nome) {
		return null;
	}
	
	public List<Atendimento> buscarAtendimentos() {
		return atendimentoRepository.findAll();
	}

}
