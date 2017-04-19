package br.indra.atendimento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.indra.atendimento.model.Funcionario;
import br.indra.atendimento.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Boolean salvarFuncionario(Funcionario funcionario) {
		
		try{
			funcionarioRepository.save(funcionario);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean excluirFuncionario(Long id) {
		
		try {
			funcionarioRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Funcionario> buscarFuncionarioPorNome(String nome) {
		return null;
	}
	
	public List<Funcionario> buscarFuncionarios() {
		return funcionarioRepository.findAll();
	}

}
