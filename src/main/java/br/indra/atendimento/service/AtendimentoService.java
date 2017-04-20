package br.indra.atendimento.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.indra.atendimento.model.Atendimento;
import br.indra.atendimento.repository.AtendimentoRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	private List<Atendimento> listaAtendimento;
	private List<Atendimento> listaAtendimentoNormal;
	private List<Atendimento> listaAtendimentoPreferencial;

	public Boolean buscarAtendimentos() {
		try {
			listaAtendimento = new ArrayList<>();
			listaAtendimentoNormal = new ArrayList<>();
			listaAtendimentoPreferencial = new ArrayList<>();
			listaAtendimento = atendimentoRepository.buscarAtendimentosPendentes();
			if (!listaAtendimento.isEmpty() || listaAtendimento != null) {
				listaAtendimento.forEach(this::separarListaAtendimento);
			}
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

	public boolean finalizarAtendimento(Character status, Long id) {
		try {
			Atendimento atd = new Atendimento();
			atd.setId(id);
			atd.setDataHora(new Date());
			atendimentoRepository.save(atd);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
