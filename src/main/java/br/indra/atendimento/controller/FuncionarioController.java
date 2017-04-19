package br.indra.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.indra.atendimento.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping
	public ModelAndView funcionario() {
		ModelAndView mv = new ModelAndView("/funcionarios");
		return mv;
	}
}
