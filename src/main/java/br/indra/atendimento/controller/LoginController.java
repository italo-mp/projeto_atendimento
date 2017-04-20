package br.indra.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.indra.atendimento.model.Funcionario;
import br.indra.atendimento.service.FuncionarioService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping
	public ModelAndView login() {		
		return new ModelAndView("/login");
	}
	
	@GetMapping(value = "/buscarPorNome/{nome}")
	@ResponseBody
	public Funcionario funcionario(@PathVariable(value = "nome") String nome) {
		return funcionarioService.buscarPorNome(nome);
	}

}
