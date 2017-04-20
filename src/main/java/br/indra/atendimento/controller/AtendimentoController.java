package br.indra.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.indra.atendimento.service.AtendimentoService;

@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;

	@RequestMapping
	public ModelAndView atendimento() {
		ModelAndView mv = new ModelAndView("/atendimento");
		if (atendimentoService.buscarAtendimentos()) {
			mv.addObject("listaAtendimentoCompleta", atendimentoService.getListaAtendimento());
			mv.addObject("listaAtendimentoNormal", atendimentoService.getListaAtendimentoNormal());
			mv.addObject("listaAtendimentoPreferencial", atendimentoService.getListaAtendimentoPreferencial());
			System.out.println("Normal: " + atendimentoService.getListaAtendimentoNormal().size());
			System.out.println("Prefe: " + atendimentoService.getListaAtendimentoPreferencial().size());
			System.out.println("Total: " + atendimentoService.getListaAtendimento().size());

		}
		return mv;
	}
}
