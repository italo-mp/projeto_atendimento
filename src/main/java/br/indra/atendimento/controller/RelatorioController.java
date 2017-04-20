package br.indra.atendimento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

	@GetMapping
	public ModelAndView relatorios() {
		ModelAndView mv = new ModelAndView("/relatorios");
		return mv;
	}
	
	
}
