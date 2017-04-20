package br.indra.atendimento.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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

	public Boolean buscarAtendimentos(String nomeBusca) {
		try {
			if (nomeBusca == null || nomeBusca.isEmpty()) {
				listaAtendimento = atendimentoRepository.buscarAtendimentosPendentes();
			} else {
				listaAtendimento = atendimentoRepository.buscarNomeESenha(nomeBusca);
			}
			if (!listaAtendimento.isEmpty()) {
				listaAtendimentoNormal = listaAtendimento.stream().filter(la -> la.getTipoAtendimento() == 'N')
						.sorted((la, la2) -> la.getId().compareTo(la2.getId())).collect(Collectors.toList());
				listaAtendimentoPreferencial = listaAtendimento.stream().filter(lp -> lp.getTipoAtendimento() != 'N')
						.sorted((lp, lp2) -> lp.getId().compareTo(lp2.getId())).collect(Collectors.toList());
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
			atendimentoRepository.finalizarAtendimento(status, new Date(), id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean excluirAtendimento(Long id) {
		try {
			atendimentoRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean atenderCliente(Long id) {
		try {
			atendimentoRepository.atenderCliente('A', id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
