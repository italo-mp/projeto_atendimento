package br.indra.atendimento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.indra.atendimento.model.Atendimento;
import br.indra.atendimento.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	private List<Atendimento> listaAtendimento;
	private List<Atendimento> listaAtendimentoNormal;
	private List<Atendimento> listaAtendimentoPreferencial;

	public AtendimentoService() {
		listaAtendimento = new ArrayList<>();
		listaAtendimentoNormal = new ArrayList<>();
		listaAtendimentoPreferencial = new ArrayList<>();

	}

	public Boolean buscarAtendimentos() {
		try {
			listaAtendimento = atendimentoRepository.findAll();
			listaAtendimento.forEach(this::separarListaAtendimento);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void separarListaAtendimento(Atendimento atendimento) {
		if (atendimento.getTipoAtendimento() == 'N') {
			listaAtendimentoNormal.add(atendimento);
		} else {
			listaAtendimentoPreferencial.add(atendimento);
		}
	}

	public List<Atendimento> getListaAtendimento() {
		return listaAtendimento;
	}

	public List<Atendimento> getListaAtendimentoNormal() {
		return listaAtendimentoNormal;
	}

	public List<Atendimento> getListaAtendimentoPreferencial() {
		return listaAtendimentoPreferencial;
	}

}
