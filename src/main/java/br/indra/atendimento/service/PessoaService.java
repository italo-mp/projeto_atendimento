package br.indra.atendimento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.indra.atendimento.model.Atendimento;
import br.indra.atendimento.model.Pessoa;
import br.indra.atendimento.repository.AtendimentoRepository;
import br.indra.atendimento.repository.PessoaRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	public Boolean salvarPessoa(Pessoa pessoa, Character tipoAtendimento) {
		try {
			pessoaRepository.save(pessoa);
			if (tipoAtendimento != null) {
				atendimentoRepository.save(new Atendimento(pessoa, 1l, 'P', tipoAtendimento));
			}
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
