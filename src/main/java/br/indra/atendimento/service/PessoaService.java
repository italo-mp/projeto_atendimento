package br.indra.atendimento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.indra.atendimento.model.Pessoa;
import br.indra.atendimento.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Boolean salvarPessoa(Pessoa pessoa) {
		try {
			pessoaRepository.save(pessoa);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean excluirPessoa(Long id) {
		try {
			pessoaRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Pessoa> buscarPessoaPorNome(String nome) {
		return pessoaRepository.findByNomeContaining(nome);
	}

	public List<Pessoa> buscarPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa buscarParaEditar(Long id) {
		return pessoaRepository.findOne(id);
	}

}
