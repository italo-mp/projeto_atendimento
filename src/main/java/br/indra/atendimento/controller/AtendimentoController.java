package br.indra.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.indra.atendimento.model.Funcionario;
import br.indra.atendimento.service.AtendimentoService;

@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;

	@RequestMapping
	public ModelAndView atendimento() {
		ModelAndView mv = new ModelAndView("/atendimento");
		mv.addObject("listaAtendimentos",atendimentoService.buscarAtendimentos());
		mv.addObject(new Funcionario());
		return mv;
	}
}
